# vegardit-maven-parent - the Mother of all Maven parent POMs

[![Build Status](https://github.com/vegardit/vegardit-maven-parent/workflows/Build/badge.svg "GitHub Actions")](https://github.com/vegardit/vegardit-maven-parent/actions?query=workflow%3ABuild)
[![License](https://img.shields.io/github/license/vegardit/vegardit-maven-parent.svg?color=blue)](LICENSE.txt)
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg)](CODE_OF_CONDUCT.md)
[![Maven Central](https://img.shields.io/maven-central/v/com.vegardit.maven/vegardit-maven-parent)](https://central.sonatype.com/artifact/com.vegardit.maven/vegardit-maven-parent)

1. [What is it?](#what-is-it)
1. [How to use](#how-to-use)
1. [Changelog / Version History](#changelog)
1. [License](#license)


## <a name="what-is-it"></a>What is it?

Opinionated best practices [Maven](https://maven.apache.org) parent project with the following 'features':

- Configures UTF-8 as default encoding of source files and generated reports.
- Configures the [maven-toolchains-plugin](https://maven.apache.org/plugins/maven-toolchains-plugin/) to enable reproducible builds by decoupling the JDK used to run Maven and it's plugins from the JDK(s) used to compile, unit- and integration-test code.\
  Different JDKs - as defined in the local [toolchains.xml](https://maven.apache.org/ref/3.5.3/maven-core/toolchains.html) - can be selected for the different build steps via [Maven project properties](https://maven.apache.org/pom.html#Properties) like so:
    ```xml
    <properties>
       <!-- use Oracle JDK 11 for compilation -->
       <java.version>11</java.version>
       <java.vendor>oracle</java.vendor>

       <!-- use Open JDK 17 for test classes compilation and unit testing -->
       <java.version.unit-tests>17</java.version.unit-tests>
       <java.vendor.unit-tests>openjdk</java.vendor.unit-tests>

       <!-- use Open JDK 21 for integration testing -->
       <java.version.integration-tests>21</java.version.integration-tests>
       <java.vendor.integration-tests>openjdk</java.vendor.integration-tests>
    </properties>
    ```
- Configures the [Eclipse Java Compiler](https://mvnrepository.com/artifact/org.eclipse.jdt.core.compiler/ecj) instead of javac:
  - to avoid the notorious `schema change not supported` error message when remote debugging via Eclipse.
  - to avoid javac bugs when targeting older JDKs, such as ["JDK Bug 6302954: Type parameters of <T>T cannot be determined; no unique maximal instance exists for type variable T with upper bounds U,X"](https://bugs.java.com/view_bug.do?bug_id=6302954) which was only fixed 6 years after being reported.\
  The Eclipse compiler is configured via a Groovy script in a [toolchains](https://maven.apache.org/guides/mini/guide-using-toolchains.html)-aware way - which is currently not possible when
  using [plexus-compiler-eclipse](https://codehaus-plexus.github.io/plexus-compiler/plexus-compilers/plexus-compiler-eclipse/)
  or [tycho-compiler-jdt](https://wiki.eclipse.org/Tycho/FAQ#Can_I_use_the_Tycho_compiler_support_in_non-OSGi_projects.2C_too.3F).
- Allows you to use `RELEASE` as parent version value while maintaining reproducible builds of your released artifacts using this approach [MRELEASE-399](https://issues.apache.org/jira/browse/MRELEASE-399?focusedCommentId=14445455&page=com.atlassian.jira.plugin.system.issuetabpanels%3Acomment-tabpanel#comment-14445455).
- Performs Maven project property resolution/replacement in resource files under `src/main/resources` whose names match:
  ```sh
  - META-INF/MANIFEST.MF
  - **/*.cfg
  - **/*.ini
  - **/*.html
  - **/*.md
  - **/*.props
  - **/*.properties
  - **/*.txt
  - **/*.xml
  - **/*.yaml
  - **/*.yml
  ```
- Configures the [maven-enforcer-plugin](https://maven.apache.org/enforcer/maven-enforcer-plugin/usage.html) to help maintaining Maven best practices.
- Configures the [maven-checkstyle-plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/) (including extra rules from the [sevntu.checkstyle](https://github.com/sevntu-checkstyle/sevntu.checkstyle) project) to be executed in the [lifecycle phase](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#Lifecycle_Reference) `process-sources`.\
  If the file `src/etc/checkstyle.xml` exists in the project being build, then this file will be the effective ruleset to checks against.\
  If it does not exist then by default this [checkstyle configuration file](src/etc/checkstyle.xml) will be used.\
  To use a different configuration file set one of the following project properties:
  - `checkstyle.config.path`: path to a config file on your local filesystem.
  - `checkstyle.config.artifact`: Maven artifact coordinates to a config file available in a configured Maven repository. \
    The format is `<groupId>:<artifactId>:<version>:<type>[:<classifier>]`, e.g. `com.vegardit.maven:vegardit-maven-parent:2.1.3:xml:checkstyle`.
- Configures the [japicmp-maven-plugin](https://siom79.github.io/japicmp/MavenPlugin.html) to ensure [SemVer](https://semver.org/)-compliant binary compatibility between versions
- Configures the [license-maven-plugin](https://www.mojohaus.org/license-maven-plugin/) to block dependencies licensed under GPL/AGPL.
- Configures the [jacoco-maven-plugin](https://www.eclemma.org/jacoco/trunk/doc/maven.html) for [test coverage](https://en.wikipedia.org/wiki/Code_coverage).
- Executes test classes named `*Test` as unit-tests with the [maven-surefire-plugin](https://maven.apache.org/surefire/maven-surefire-plugin/) and test classes named `*ITest` as integration-tests with the [maven-failsafe-plugin](https://maven.apache.org/surefire/maven-failsafe-plugin/) in the verify [licefycle phase](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).
- Displays execution times of Maven plugins at the end of the build via [maven-buildtime-extension](https://github.com/timgifford/maven-buildtime-extension), e.g.:
  ```py
  [INFO] ------------------------------------------------------------------------
  [INFO] Total time:  6.175 s
  [INFO] Finished at: 2023-10-02T12:16:18+02:00
  [INFO] ------------------------------------------------------------------------
  [INFO] Build Time Summary:
  [INFO]
  [INFO] vegardit-maven-parent
  [INFO]   maven-enforcer-plugin:enforce (require-fixed-plugin-versio [0.010s]
  [INFO]   maven-enforcer-plugin:enforce (basic-checks@validate) .... [0.149s]
  [INFO]   japicmp-maven-plugin:cmp (cmp@package) ................... [0.194s]
  [INFO]   maven-checkstyle-plugin:check (check@process-sources) .... [0.848s]
  [INFO]   maven-site-plugin:attach-descriptor (attach-descriptor) .. [0.405s]
  [INFO]   maven-enforcer-plugin:enforce (enforce-bytecode-version@va [0.003s]
  [INFO]   jacoco-maven-plugin:report (post-unit-test) .............. [0.003s]
  [INFO]   maven-toolchains-plugin:toolchain (toolchain@validate) ... [0.031s]
  [INFO]   maven-bundle-plugin:manifest (manifest@process-classes) .. [0.008s]
  [INFO]   maven-dependency-plugin:properties (properties@initialize) [0.414s]
  [INFO]   exec-maven-plugin:exec (ecj@test-compile) ................ [0.001s]
  [INFO]   maven-clean-plugin:clean (default-clean) ................. [0.045s]
  [INFO]   gmavenplus-plugin:execute (groovy.script.onProcessResource [0.032s]
  [INFO]   build-helper-maven-plugin:attach-artifact (attach-files) . [0.003s]
  [INFO]   maven-enforcer-plugin:enforce (ban-duplicate-classes@valid [0.004s]
  [INFO]   exec-maven-plugin:exec (ecj@compile) ..................... [0.031s]
  [INFO]   jacoco-maven-plugin:prepare-agent (pre-unit-test) ........ [0.075s]
  [INFO]   maven-toolchains-plugin:toolchain (toolchain@process-test- [0.003s]
  [INFO]   dependencyversion-maven-plugin:set-version (set-version@in [0.063s]
  [INFO]   build-helper-maven-plugin:parse-version (parse-version) .. [0.036s]
  [INFO]   maven-antrun-plugin:run (delete-java-stubs@process-classes [0.022s]
  [INFO]   gmavenplus-plugin:execute (groovy.script.onInitialize@init [1.783s]
  [INFO]   license-maven-plugin:add-third-party (check-thirdparty-lic [0.467s]
  [INFO]   dependency-scope-maven-plugin:check (check@validate) ..... [0.128s]
  [INFO]   maven-enforcer-plugin:enforce (dependency-convergence@vali [0.006s]
  [INFO] ------------------------------------------------------------------------
  ```
- The [jrebel-maven-plugin](https://manuals.zeroturnaround.com/jrebel/standalone/maven.html) will be enabled automatically if the file `src/main/resources/rebel-remote.xml` is present in a project.

### Additional Maven project properties
Additional Maven project properties are referenceable without any further configuration:
  1. The [os-maven-plugin](https://github.com/trustin/os-maven-plugin) is configured to provide platform-specific project properties that allows easy inclusion of native dependencies, e.g.
     ```xml
     <dependency>
        <groupId>io.netty</groupId>
        <artifactId>netty-tcnative</artifactId>
        <version>2.0.36</version>
        <classifier>${os.detected.classifier}</classifier> <!-- property "os.detected.classifier" is provided by os-maven-plugin -->
     </dependency>
     ```
  1. The [maven-dependency-plugin](https://maven.apache.org/plugins/maven-dependency-plugin/properties-mojo.html) sets a property pointing to the artifact file for each project dependency following the pattern `${<groupId>:<artifactId>:<type>[:classifier]}`, e.g. `${com.google.guava:guava:jar}`.\
     See ["Stackoverflow: Can I use the path to a Maven dependency as a property?"](https://stackoverflow.com/a/2359947)
  1. The [dependencyversion-maven-plugin](https://gitlab.com/josh.cain/dependencyversion-maven-plugin) sets a property containing the version of each project dependency following the pattern `${<groupId>:<artifactId>:<type>[:classifier].version}`, e.g. `${com.google.guava:guava:jar.version}`.
  1. The [parse-version](https://www.mojohaus.org/build-helper-maven-plugin/parse-version-mojo.html) goal of the [build-helper-maven-plugin](https://www.mojohaus.org/build-helper-maven-plugin/index.html) sets the following properties:
     ```python
     ${parsedVersion.majorVersion}
     ${parsedVersion.minorVersion}
     ${parsedVersion.incrementalVersion}
     ${parsedVersion.qualifier}
     ${parsedVersion.buildNumber}
     ```

### Maven Site improvements:
  1. WebDAV and SFTP protocols enabled for [Maven site deployment](https://maven.apache.org/plugins/maven-site-plugin/examples/adding-deploy-protocol.html).
  1. Markdown rendering support is enabled by default via [doxia-module-markdown](https://mvnrepository.com/artifact/org.apache.maven.doxia/doxia-module-markdown)
  1. Contains workaround for `SiteToolException: The site descriptor cannot be resolved from the repository:
ArtifactResolutionException: Unable to locate site descriptor`.\
    See ["Stackoverflow: How to avoid checking parent project in maven-site-plugin?"](https://stackoverflow.com/a/40907580) or ["Unable to locate site descriptor : maven-site-plugin problem"](https://tcollignon.github.io/2016/10/24/Unable-to-locate-site-descriptor-maven-site-plugin-problem.html) for details.

### Enables workarounds for some build annoyances such as:
  1. Maven generate-sources goal being executed twice. See ["Peter Lynch: How to prevent generate-sources phase executing twice"](http://blog.peterlynch.ca/2010/05/maven-how-to-prevent-generate-sources.html) and ["Stackoverflow: Maven phase executing twice"](https://stackoverflow.com/questions/4253700/maven-phase-executing-twice)
  1. Javadoc failing when incomplete tags exist on Java 8+. See ["Stackoverflow: Maven is not working in Java 8 when Javadoc tags are incomplete"](https://stackoverflow.com/a/16743137)
  1. `getClass().getPackage().getImplementationVersion()` for your classes in JARs and WARs will correctly return the Maven project version. See ["Stackoverflow: Get Maven artifact version at runtime"](https://stackoverflow.com/a/2713013)


##  <a name="how-to-use"></a>How to use

### Using release builds

Releases of this project are available at https://search.maven.org/artifact/com.vegardit.maven/vegardit-maven-parent

Add the following `parent` declaration to your Maven project `pom.xml`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
       <groupId>com.vegardit.maven</groupId>
       <artifactId>vegardit-maven-parent</artifactId>
       <version>RELEASE</version>
    </parent>

    <groupId><!-- your groupId here --></groupId>
    <artifactId><!-- your artifactId here --></artifactId>
    <version><!-- your version here --></version>

    <!-- ... other project settings --->
</project>
```


### Using snapshot builds

Snapshots of this project are available at https://github.com/vegardit/vegardit-maven-parent/tree/mvn-snapshots-repo

Ensure your `~/.m2/settings.xml` contains the project's snapshots repository, e.g.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
   <profiles>
      <profile>
         <id>vegardit-maven-parent-snapshots</id>
         <repositories>
            <repository>
                <id>vegardit-maven-parent-snapshots</id>
                <url>https://raw.githubusercontent.com/vegardit/vegardit-maven-parent/mvn-snapshots-repo/</url>
                <releases> <enabled>false</enabled></releases>
                <snapshots><enabled>true</enabled> </snapshots>
            </repository>
         </repositories>
      </profile>
   </profiles>
   <activeProfiles>
      <activeProfile>vegardit-maven-parent-snapshots</activeProfile>
   </activeProfiles>
</settings>
```

Add the following `parent` declaration to your Maven project `pom.xml`.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

   <modelVersion>4.0.0</modelVersion>

   <parent>
      <groupId>com.vegardit.maven</groupId>
      <artifactId>vegardit-maven-parent</artifactId>
      <version>LATEST</version>
   </parent>

   <groupId><!-- your groupId here --></groupId>
   <artifactId><!-- your artifactId here --></artifactId>
   <version><!-- your version here --></version>

   <!-- ... other project settings --->
</project>
```


## <a name="changelog"></a>Changelog / Version History

This project maintains a [changelog](CHANGELOG.md) and adheres to [Semantic Versioning](https://semver.org) and [Keep a CHANGELOG](https://keepachangelog.com)


## <a name="license"></a>License

All files are released under the [Apache License 2.0](LICENSE.txt).

Individual files contain the following tag instead of the full license text:
```
SPDX-License-Identifier: Apache-2.0
```

This enables machine processing of license information based on the SPDX License Identifiers that are available here: https://spdx.org/licenses/.
