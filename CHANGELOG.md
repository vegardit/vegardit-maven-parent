# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [Unreleased]


## [2.4.31] - 2021-07-07

### Changed
- change Checkstyle rule Indentation.lineWrappingIndentation from 3 to 0
- Maven plugin upgrades:
  - checkstyle 8.39 to 8.43
  - doxia-module-markdown from 1.9.1 to 1.10
  - formatter-maven-plugin 2.14.0 to 2.16.0
  - jacoco-maven-plugin 0.8.6 to 0.8.7
  - maven-dependency-plugin from 3.1.2 to 3.2.0
  - maven-javadoc-plugin from 3.2.0 to 3.3.0
  - maven-project-info-reports-plugin 3.1.1 to 3.1.2
  - sevntu-checks from 1.39.0 to 1.40.0
- upgrading gmavenplus-plugin's groovy to 3.0.8


## [2.4.30] - 2021-04-10

### Added
- add [depcheck-maven-plugin](https://github.com/vegardit/depcheck-maven-plugin)

### Changed
- increase minimum required Maven version to 3.6.0
- enabled additional checkstyle checks
  - [InvalidJavadocPosition](https://checkstyle.sourceforge.io/config_javadoc.html#InvalidJavadocPosition)
  - [JavadocBlockTagLocation](https://checkstyle.sourceforge.io/config_javadoc.html#JavadocBlockTagLocation)
  - [JavadocContentLocation](https://checkstyle.sourceforge.io/config_javadoc.html#JavadocContentLocation)
  - [JavadocMissingLeadingAsterisk](https://checkstyle.sourceforge.io/config_javadoc.html#JavadocMissingLeadingAsterisk)
  - [JavadocMissingWhitespaceAfterAsterisk](https://checkstyle.sourceforge.io/config_javadoc.html#JavadocMissingWhitespaceAfterAsterisk)
  - [RequireEmptyLineBeforeBlockTagGroup](https://checkstyle.sourceforge.io/config_javadoc.html#RequireEmptyLineBeforeBlockTagGroup)
  - [UnnecessarySemicolonInEnumeration](https://checkstyle.sourceforge.io/config_coding.html#UnnecessarySemicolonInEnumeration)
- upgrade to Eclipse Java Compiler 3.25.0
- Maven plugin upgrades:
  - checkstyle 8.36.2 to 8.39
  - flatten-maven-plugin from 1.2.5 to 1.2.7
  - formatter-maven-plugin from 2.14.0 to 2.15.0
  - japicmp-maven-plugin from 0.15.2 to 0.15.3
  - maven-bundle-plugin from 5.1.1 to 5.1.2
  - sevntu-checks from 1.38.0 to 1.39.0
  - sign-maven-plugin from 0.3.0 to 0.3.1


## [2.4.29] - 2021-03-01

### Changed
- profile `ci-deploy-snapshots-to-github` to `deploy-snapshots-to-github`
- profile `maven-central-release` to `deploy-releases-to-maven-central`


## [2.4.28] - 2021-02-26

### Fixed
- mvn compile fails on linux with "Unrecognized option :"

### Added
- project property `nexus-staging-maven-plugin.nexusUrl`


## [2.4.27] - 2021-02-26

### Changed
- Maven plugin upgrades:
  - maven-wagon from 3.4.2 to 3.4.3


## [2.4.26] - 2021-02-24

### Fixed
- sign-maven-plugin is executed before maven-sources-plugin and maven-javadoc-plugin


## [2.4.25] - 2021-02-21

### Fixed
- additional source paths are ignored during compilation

### Changed
- publish to Maven Central instead of Bintray because of its [termination](https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter/)
- Maven plugin upgrades:
  - checkstyle 8.35 to 8.36.2
  - os-maven-plugin 8.35 to 8.36.1
  - maven-checkstyle-plugin from 3.1.1 to 3.1.2
  - formatter-maven-plugin from 2.13.0 to 2.14.0


## [2.4.24] - 2021-01-24

### Fixed
- "Error assembling JAR: Manifest file: target/classes/META-INF/MANIFEST.MF does not exist." when building Maven plugins.

### Added
- check to prevent dependencies licensed under GPL

### Changed
- minimum required Maven version is now 3.5.4
- upgrade to Eclipse Java Compiler 3.24.0
- Maven plugin upgrades:
  - japicmp-maven-plugin from 0.15.1 to 0.15.2
  - maven-resources-plugin from 3.1.0 to 3.2.0


## [2.4.22] - 2021-01-05

### Added
- run **maven-toolchains-plugin:toolchain** goal in validate phase
- Maven plugin upgrades:
  - gmavenplus-plugin from 1.11.0 to 1.12.1
  - japicmp-maven-plugin from 0.14.4 to 0.15.1
  - maven-ear-plugin from 3.1.0 to 3.2.0
  - maven-wagon from 3.4.1 to 3.4.2
- upgrading gmavenplus-plugin's groovy to 3.0.7


## [2.4.21] - 2020-11-07

### Changed
- upgrade to Eclipse Java Compiler 3.23.0
- support toolchain aware compilation of Java 9+ Maven projects with Eclipse Java Compiler


## [2.4.19] - 2020-11-06

### Changed
- migrate from Travis CI to GitHub Actions
- Maven plugin upgrades:
  - sevntu-checks from 1.37.1 to 1.38.0


## [2.4.18] - 2020-11-01

### Changed
- downgrading maven-resources-plugin from 3.2.0 to 3.1.0 as new version is broken


## [2.4.17] - 2020-11-01

### Added
- fast-build profile that skips checks and tests
- maven property `project.build.outputTimestamp` to set the modification timestamp of all classes in the final jar match the build timestamp

### Changed
- Maven plugin upgrades:
  - checkstyle 8.32 to 8.35
  - build-helper-maven-plugin from 3.1.0 to 3.2.0
  - exec-maven-plugin from 1.6.0 to 3.0.0
  - extra-enforcer-rules from 1.2 to 1.3
  - flatten-maven-plugin from 1.2.2 to 1.2.4
  - formatter-maven-plugin from 2.11.0 to 2.13.0
  - gmavenplus-plugin from 1.8.1 to 1.11.0
  - jacoco-maven-plugin from 0.8.5 to 0.8.6
  - japicmp-maven-plugin from 0.14.3 to 0.14.4
  - maven-assembly-plugin from 3.2.0 to 3.3.0
  - maven-bundle-plugin from 4.2.1 to 5.1.1
  - maven-ear-plugin from 3.0.2 to 3.1.0
  - maven-ejb-plugin from 3.0.1 to 3.1.0
  - maven-project-info-reports-plugin from 3.0 to 3.1.1
  - maven-shade-plugin from 3.2.3 to 3.2.4
  - maven-site-plugin from 3.9.0 to 3.9.1
  - maven-war-plugin from 3.2.3 to 3.3.1
  - maven-wagon from 3.4.0 to 3.4.1
- upgrade to Eclipse Java Compiler 3.22.0
- upgrading gmavenplus-plugin's groovy to 3.0.6


## [2.4.16] - 2020-05-11

### Changed
- set maven-release-plugin `<checkModificationExclude>pom.xml</checkModificationExclude>`
- Maven plugin upgrades:
  - checkstyle 8.30 to 8.31


## [2.4.15] - 2020-04-27

### Changed
- use Sevntu's [LineLengthExtendedCheck](https://github.com/sevntu-checkstyle/sevntu.checkstyle/blob/master/sevntu-checks/src/main/java/com/github/sevntu/checkstyle/checks/sizes/LineLengthExtendedCheck.java) instead of Checkstyle's [LineLengthCheck](https://github.com/checkstyle/checkstyle/blob/master/src/main/java/com/puppycrawl/tools/checkstyle/checks/sizes/LineLengthCheck.java) for Java source code to workaround [Checkstyle issue #7460](https://github.com/checkstyle/checkstyle/issues/7460)
- upgrade to Eclipse Java Compiler 3.21.0
- Maven plugin upgrades:
  - maven-antrun-plugin 1.8 to 3.0.0


## [2.4.14] - 2020-04-15

### Changed
- set maven-install-plugin `installAtEnd` to `true`
- set maven-deploy-plugin `deployAtEnd` to `true`
- Maven plugin upgrades:
  - maven-shade-plugin 3.2.2 to 3.2.3
  - gmavenplus-plugin from 1.8.1 to 1.9.0
  - flatten-maven-plugin 1.2.1 to 1.2.2


## [2.4.13] - 2020-03-21

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin from 3.0.0 to 3.1.0
  - checkstyle 8.27 to 8.30
  - dependency-scope-maven-plugin 0.10
  - flatten-maven-plugin 1.2.1
  - japicmp-maven-plugin 0.14.3
  - maven-checkstyle-plugin from 3.1.0 to 3.1.1
  - maven-dependency-plugin from 3.1.1 to 3.1.2
  - maven-javadoc-plugin from 3.1.1 to 3.2.0
  - maven-shade-plugin from 3.2.1 to 3.2.2
  - maven-site-plugin from 3.8.2 to 3.9.0
  - maven-source-plugin from 3.2.0 to 3.2.1
  - sevntu-checks from 1.36.0 to 1.37.1
- removed deprecated checkstyle rules JavadocMethod.allowMissingThrowsTags/allowUndeclaredRTE/allowThrowsTagsForSubclasses/suppressLoadErrors, see https://github.com/checkstyle/checkstyle/issues/7329


## [2.4.10] - 2019-12-20

### Changed
- apply checkstyle LineLengthCheck only to java,js,xml files


## [2.4.8] - 2019-12-20

### Changed
- add `-Djava.rmi.server.hostname=localhost` to surefire-plugin config
- upgrade to Eclipse Compiler 3.20.0
- Maven plugin upgrades:
  - checkstyle 8.20 to 8.27
  - gmavenplus-plugin from 1.7.1 to 1.8.1
  - jacoco-maven-plugin from 0.8.4 to 0.8.5
  - japicmp-maven-plugin 0.14.2
  - maven-assembly-plugin from 3.1.1 to 3.2.0
  - maven-ear-plugin from 3.0.1 to 3.0.2
  - maven-enforcer-plugin 3.0-M3
  - maven-jar-plugin from 3.1.2 to 3.2.0
  - maven-source-plugin from 3.1.0 to 3.2.0
  - maven-wagon 3.3.4
  - sevntu-checks 1.35.0 to 1.36.0


## [2.4.7] - 2019-11-01

### Changed
- Maven plugin upgrades:
  - maven-site-plugin 3.8.2
  - rebel-maven-plugin 1.1.10
  - maven-bundle-plugin 4.2.1
  - sevntu-checkstyle-maven-plugin 1.35.0


## [2.4.6] - 2019-07-17

### Changed
- removed Eclipse Compiler option "-genericsignature" to prevent maven-bundle-plugin, javac and javadoc from failing to parse generated bytecode
- Maven plugin upgrades:
  - maven-bundle-plugin 4.2.0


## [2.4.5] - 2019-07-16

### Changed
- upgrade to Eclipse Compiler 3.18.0


## [2.4.4] - 2019-07-15

### Changed
- Maven plugin upgrades:
  - jacoco-maven-plugin 0.8.4
  - maven-javadoc-plugin 3.1.1


## [2.4.3] - 2019-06-26

### Fixed
- maven-bundle-plugin fails with `java.lang.IllegalArgumentException: invalid signature: * at aQute.bnd.signatures.Signatures.parseReferenceTypeSignature(Signatures.java:63)`
   - downgrading maven-bundle-plugin to 4.0.0


## [2.4.2] - 2019-06-26

### Changed
- Maven plugin upgrades:
  - gmavenplus-plugin 1.7.1
  - maven-toolchains-plugin 3.0.0
  - maven-wagon 3.3.3
  - sevntu-checkstyle 1.34.1


## [2.4.1] - 2019-05-29

### Fixed
- build fails if src/test/java does not exist
- checkstyle fails with IncompatibleClassChangeError - downgrading to checkstyle 8.20 because of https://github.com/sevntu-checkstyle/sevntu.checkstyle/issues/745


## [2.4.0] - 2019-05-29

### Added
- default config for flatten-maven-plugin

### Changed
- relax AvoidConditionInversionCheck and NewlineAtEndOfFile checkstyle rules
- Maven plugin upgrades:
  - checkstyle 8.21
  - gmavenplus-plugin 1.7.0
  - japicmp-maven-plugin 0.14.1
  - maven-checkstyle-plugin 3.1.0
  - maven-jar-plugin 3.1.2
  - maven-failsafe-plugin 2.22.2
  - maven-surefire-plugin 2.22.2
  - maven-source-plugin 3.1.0
  - maven-war-plugin 3.2.3
  - os-maven-plugin 1.6.2

### Fixed
- build fails if artifact has no test classes
- japicmp flags new default interface methods as binary incompatible change


## [2.3.0] - 2019-05-04

### Added
- sevntu-checkstyle rules


## [2.2.2] - 2019-05-01

### Changed
- upgrade to Eclipse Compiler 3.17.0
- add exclusion for maven-checkstyle-plugin to org.eclipse.m2e:lifecycle-mapping


## [2.2.1] - 2019-04-29

### Changed
- use "groovy-all" instead of "groovy-ant" plugin dependency for gmavenplus plugin
- Maven plugin upgrades:
  - checkstyle 8.20


## [2.2.0] - 2019-04-15

### Fixed
- Surefire tests may fail on Jenkins containers with latest OpenJDK8, see https://github.developer.allianz.io/azd/jenkins-slave-maven/issues/70

### Added
- checkstyle ignore filters for binary files
- configured [japicmp-maven-plugin](https://siom79.github.io/japicmp/MavenPlugin.html) to ensure [SemVer](https://semver.org/)-compliant binary compatibility between versions

### Changed
- minimum required Maven version is now 3.5.0
- Maven plugin upgrades:
  - checkstyle 8.19
  - extra-enforcer-rules 1.2
  - gmavenplus-plugin 1.6.3
  - jacoco-maven-plugin 0.8.3
  - jrebel-maven-plugin 1.1.9
  - maven-assembly-plugin 3.1.1
  - maven-bundle-plugin 4.1.0
  - maven-compiler-plugin 3.8.0
  - maven-ear-plugin 3.0.1
  - maven-jar-plugin 3.1.1
  - maven-project-info-reports-plugin 3.0.0
  - maven-javadoc-plugin 3.1.0
  - maven-scm-plugin 1.11.2
  - maven-shade-plugin 3.2.1
  - maven-surefire-report-plugin 2.22.1
  - maven-wagon 3.3.2
  - versions-maven-plugin 2.7
- maven-enforcer-plugin: enforceBytecodeVersion.ignoreOptionals=true
- maven-failesafe/surefire-plugin: runOrder=alphabetical, -Dcom.ibm.jsse2.overrideDefaultTLS=true, trimStackTrace=false
- maven-project-info-reports-plugin: extended reports list

### Removed
- checkstyle rule `UncommentedMain`


## [2.1.3] - 2018-06-28

### Fixed
- setting completionGoals `clean install -DskipTests=true` to workaround still present multi-module release issue [MRELEASE-271](https://issues.apache.org/jira/browse/MRELEASE-271)


## [2.1.2] - 2018-06-28

### Fixed
- remove maven-javadoc-plugin:javadoc-no-fork build goal to prevent javadoc running twice (which is als executed by `jar` goal)
- setting preparationGoals `clean install` to workaround still present multi-module release issue [MRELEASE-271](https://issues.apache.org/jira/browse/MRELEASE-271)


## [2.1.1] - 2018-06-27

### Fixed
- downgrade to maven-enforcer-plugin 3.0-M1 because of [MENFORCER-306](https://issues.apache.org/jira/projects/MENFORCER/issues/MENFORCER-306)


## [2.1.0] - 2018-06-27

### Added
- maven-checkstyle-plugin config
- src/etc/checkstyle.xml
- src/etc/eclipse-formatter.xml

### Changed
- upgrade to maven-surefire-plugin 2.22.0
- upgrade to maven-failsafe-plugin 2.22.0
- upgrade to maven-enforcer-plugin 3.0-M2


## [2.0.2] - 2018-06-14

### Fixed
- Use OS specific classpath entry separator char


## [2.0.1] - 2018-06-14

### Changed
- renamed server-id "github.com" to "github-commits"
- renamed distribution-repo-id/server-id "bintray-vegardit-maven-public-releases" to "bintray-releases"
- update Maven SCM to 1.10.0


## [2.0.0] - 2018-06-12

### Added
- First public release


## [1.0.x] 2013-2018

- internal releases
