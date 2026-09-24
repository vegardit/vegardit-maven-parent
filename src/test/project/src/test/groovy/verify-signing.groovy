/*
 * SPDX-FileCopyrightText: © Vegard IT GmbH (https://vegardit.com)
 * SPDX-FileContributor: Sebastian Thomschke
 * SPDX-License-Identifier: Apache-2.0
 * SPDX-ArtifactOfProjectHomePage: https://github.com/vegardit/vegardit-maven-parent
 *
 * Checks the inherited signing contract using disposable keys and isolated Maven consumers.
 * Child builds cannot access the developer's signing credentials, settings, home, or GPG commands.
 */
import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper
import java.nio.file.Files
import java.security.KeyPairGenerator
import java.util.concurrent.TimeUnit
import org.bouncycastle.bcpg.ArmoredOutputStream
import org.bouncycastle.bcpg.HashAlgorithmTags
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags
import org.bouncycastle.openpgp.PGPObjectFactory
import org.bouncycastle.openpgp.PGPPublicKey
import org.bouncycastle.openpgp.PGPSecretKey
import org.bouncycastle.openpgp.PGPSignature
import org.bouncycastle.openpgp.PGPSignatureList
import org.bouncycastle.openpgp.PGPUtil
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyEncryptorBuilder
import org.bouncycastle.openpgp.operator.bc.BcPGPContentSignerBuilder
import org.bouncycastle.openpgp.operator.bc.BcPGPContentVerifierBuilderProvider
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider
import org.bouncycastle.openpgp.operator.jcajce.JcaPGPKeyPair

if (['skipTests', 'skipITs', 'maven.test.skip'].any {
   (session.userProperties[it] ?: project.properties[it])?.toBoolean()
}) {
   log.info('Skipping signing integration tests.')
   return
}

def parentPom = project.parent.file
def parentModel = new XmlSlurper().parse(parentPom)
def releaseProfile = parentModel.profiles.profile.find { it.id.text() == 'deploy-releases-to-maven-central' }
// Read the inherited execution so the test does not duplicate its version or lifecycle binding.
def signingPlugin = releaseProfile.build.plugins.plugin.find {
   it.executions.execution.any { execution -> execution.id.text() == 'sign@verify' }
}
assert signingPlugin.size() == 1: 'The release profile must bind signing to verify.'
def signingExecution = signingPlugin.executions.execution.find { it.id.text() == 'sign@verify' }
assert signingExecution.phase.text() == 'verify'
def pluginVersion = signingPlugin.version.text()
def signingGoal = "${signingPlugin.groupId.text()}:${signingPlugin.artifactId.text()}:${pluginVersion}:${signingExecution.goals.goal.text()}@sign@verify"

def outputDirectory = new File(project.build.directory)
outputDirectory.mkdirs()
def testDirectory = Files.createTempDirectory(outputDirectory.toPath(), 'signing-').toFile()
def settingsFile = new File(testDirectory, 'settings.xml')
settingsFile.setText('<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"/>', 'UTF-8')
def mavenHome = new File(System.getProperty('maven.home'))
def bootJar = new File(mavenHome, 'boot').listFiles().find { it.name.startsWith('plexus-classworlds-') && it.name.endsWith('.jar') }
assert bootJar != null
def javaExecutable = new File(System.getProperty('java.home'), 'bin/' + (File.separatorChar == '\\' ? 'java.exe' : 'java'))

def passphrase = UUID.randomUUID().toString()
def generator = KeyPairGenerator.getInstance('RSA')
generator.initialize(2048)
def keyPair = new JcaPGPKeyPair(PGPPublicKey.RSA_GENERAL, generator.generateKeyPair(), new Date())
def digest = new BcPGPDigestCalculatorProvider().get(HashAlgorithmTags.SHA1)
def armorKey = { boolean encrypted ->
   def encryptor = encrypted ? new BcPBESecretKeyEncryptorBuilder(SymmetricKeyAlgorithmTags.AES_256, digest)
      .build(passphrase.toCharArray()) : null
   def secretKey = new PGPSecretKey(PGPSignature.POSITIVE_CERTIFICATION, keyPair,
      'Disposable signing test <signing-test@example.invalid>', digest, null, null,
      new BcPGPContentSignerBuilder(PGPPublicKey.RSA_GENERAL, HashAlgorithmTags.SHA256), encryptor)
   def bytes = new ByteArrayOutputStream()
   new ArmoredOutputStream(bytes).withCloseable { secretKey.encode(it) }
   bytes.toString('UTF-8')
}
def encryptedKey = armorKey(true)
def unencryptedKey = armorKey(false)

def cases = [
   [name: 'lifecycle', key: encryptedKey, pass: passphrase, signed: true, lifecycle: true],
   [name: 'profile-inactive', lifecycle: true, active: false],
   // Central requires signatures, so a release must fail instead of silently producing unsigned artifacts.
   [name: 'lifecycle-missing-key', lifecycle: true, failure: true],
   [name: 'environment', key: encryptedKey, pass: passphrase, signed: true],
   // The parent now uses the supplied passphrase exactly, without the old plugin's trimming.
   [name: 'passphrase-not-trimmed', key: encryptedKey, pass: " ${passphrase} ", failure: true],
   [name: 'environment-precedence', key: encryptedKey, pass: passphrase, file: 'invalid', signed: true],
   [name: 'wrong-passphrase', key: encryptedKey, pass: 'incorrect', failure: true],
   [name: 'malformed-key', key: 'invalid', pass: passphrase, file: encryptedKey, failure: true],
   [name: 'malformed-file', file: 'invalid', pass: passphrase, failure: true],
   [name: 'empty-file', file: '', failure: true],
   [name: 'file-fallback', file: encryptedKey, pass: passphrase, signed: true],
   [name: 'unencrypted-key', key: unencryptedKey, signed: true],
   [name: 'missing-passphrase', key: encryptedKey, failure: true],
   [name: 'missing-key', failure: true],
   [name: 'empty-key', key: '', failure: true],
   [name: 'deployment-skipped', key: 'invalid', skip: true]
]

// Allow a failed scenario to be rerun without repeating every child build; normal verify runs all cases.
def selectedCase = session.userProperties['signingTest']
if (selectedCase) {
   cases = cases.findAll { it.name == selectedCase }
   assert !cases.isEmpty(): "Unknown signing test: ${selectedCase}"
}

cases.each { scenario ->
   def consumerDirectory = new File(testDirectory, scenario.name.toString())
   consumerDirectory.mkdirs()
   def userDirectory = new File(consumerDirectory, 'home')
   new File(userDirectory, '.m2').mkdirs()
   if (scenario.containsKey('file')) {
      new File(userDirectory, '.m2/sign-key.asc').setText(scenario.file, 'UTF-8')
   }
   def consumerPom = new File(consumerDirectory, 'pom.xml')
   consumerPom.withWriter('UTF-8') { writer ->
      new MarkupBuilder(writer).project(xmlns: 'http://maven.apache.org/POM/4.0.0') {
         modelVersion('4.0.0')
         parent {
            groupId(parentModel.groupId.text())
            artifactId(parentModel.artifactId.text())
            version(parentModel.version.text())
            relativePath(consumerDirectory.toPath().toAbsolutePath().relativize(parentPom.toPath().toAbsolutePath()).toString())
         }
         artifactId('signing-consumer')
         packaging('pom')
         if (scenario.lifecycle) {
            build {
               plugins {
                  plugin {
                     groupId('org.codehaus.mojo')
                     artifactId('build-helper-maven-plugin')
                     executions {
                        execution {
                           id('attach-signing-test')
                           // Match the parent's source/Javadoc attachment phase to catch signing too early.
                           phase('post-integration-test')
                           goals { goal('attach-artifact') }
                           configuration {
                              artifacts {
                                 artifact {
                                    file('attachment.txt')
                                    type('txt')
                                    classifier('signing-test')
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
   def attachment = new File(consumerDirectory, 'attachment.txt')
   if (scenario.lifecycle) attachment.setText('Signing must include attached artifacts.', 'UTF-8')

   // Launch Maven through Java directly: an empty PATH must be sufficient for pure Java signing on every OS.
   def command = [javaExecutable.absolutePath, "-Duser.home=${userDirectory}", "-Dmaven.home=${mavenHome}",
      "-Dmaven.conf=${new File(mavenHome, 'conf')}", "-Dclassworlds.conf=${new File(mavenHome, 'bin/m2.conf')}",
      "-Dmaven.multiModuleProjectDirectory=${consumerDirectory}", '-cp', bootJar.absolutePath,
      'org.codehaus.plexus.classworlds.launcher.Launcher', '-B', '-ntp', '-s', settingsFile.absolutePath,
      '-gs', settingsFile.absolutePath, "-Dmaven.repo.local=${session.localRepository.basedir}",
      "-Dmaven.deploy.skip=${scenario.skip ?: false}"]
   if (scenario.lifecycle) {
      // The isolated home has no toolchains; reuse both sources without exposing settings or credentials.
      ['-t': session.request.userToolchainsFile, '-gt': session.request.globalToolchainsFile].each { option, toolchainsFile ->
         // Missing default files are allowed, but Maven rejects missing explicit -t/-gt paths.
         if (toolchainsFile?.isFile()) {
            command.addAll([option, toolchainsFile.absolutePath])
         }
      }
      command.add('verify')
   } else {
      command.add(signingGoal)
   }
   def processBuilder = new ProcessBuilder(command.collect { it.toString() }).directory(consumerDirectory)
   def environment = processBuilder.environment()
   environment.keySet().removeAll {
      def name = it.toUpperCase(Locale.ROOT)
      name.startsWith('SIGN_') || name.startsWith('MAVEN_GPG_') || name.startsWith('DEPLOY_') ||
         name in ['PATH', 'JAVA_TOOL_OPTIONS', 'JDK_JAVA_OPTIONS', '_JAVA_OPTIONS', 'GNUPGHOME']
   }
   environment['PATH'] = ''
   if (scenario.active != false) environment['DEPLOY_RELEASES_TO_MAVEN_CENTRAL'] = 'true'
   if (scenario.key != null) environment['SIGN_KEY'] = scenario.key.toString()
   if (scenario.pass != null) environment['SIGN_KEY_PASS'] = scenario.pass.toString()
   def logFile = new File(consumerDirectory, 'build.log')
   def process = processBuilder.redirectErrorStream(true).redirectOutput(logFile).start()
   if (!process.waitFor(120, TimeUnit.SECONDS)) {
      process.destroyForcibly()
      throw new IllegalStateException("Signing test ${scenario.name} timed out; see ${logFile}")
   }
   assert (process.exitValue() != 0) == (scenario.failure ?: false): "${scenario.name}: unexpected exit ${process.exitValue()}; see ${logFile}"
   def buildLog = logFile.getText('UTF-8')
   assert !buildLog.contains(passphrase) && !buildLog.contains('-----BEGIN PGP PRIVATE KEY BLOCK-----'):
      "${scenario.name}: signing credentials appeared in the build log"
   def signatures = []
   consumerDirectory.eachFileRecurse { if (it.name.endsWith('.asc') && it.parentFile.name != '.m2') signatures.add(it) }
   assert signatures.size() == (scenario.signed ? (scenario.lifecycle ? 2 : 1) : 0):
      "${scenario.name}: unexpected signatures; see ${logFile}"
   signatures.each { signatureFile ->
      signatureFile.withInputStream { input ->
         def signatureList = new PGPObjectFactory(PGPUtil.getDecoderStream(input), new BcKeyFingerprintCalculator()).nextObject()
         assert signatureList instanceof PGPSignatureList
         def signature = signatureList[0]
         signature.init(new BcPGPContentVerifierBuilderProvider(), keyPair.publicKey)
         signature.update(scenario.lifecycle && signatureFile.name.endsWith('.txt.asc') ? attachment.bytes : consumerPom.bytes)
         assert signature.verify(): "${scenario.name}: invalid artifact signature"
      }
   }
   log.info("Signing compatibility: ${scenario.name} passed")
}
log.info("Signing compatibility: all ${cases.size()} cases passed without GPG; logs in ${testDirectory}")
