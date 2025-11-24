# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [Unreleased]

### Changed

- increase minimum required Maven version 3.6.3 -> 3.9.0
- Maven plugin upgrades:
  - checkstyle 12.1.1 -> 12.1.2
  - maven-ejb-plugin 3.2.1 -> 3.3.0
  - maven-jar-plugin 3.4.2 -> 3.5.0.
  - taglist-maven-plugin 3.2.1 -> 3.2.2
  - versions-maven-plugin 2.19.1 -> 2.20.0


## [6.1.14] - 2025-11-11

### Fixed

- maven-javadoc-plugin fails with `javadoc: error - invalid flag: -no-fonts`, see https://github.com/apache/maven-javadoc-plugin/issues/1244

### Changed

- Maven plugin upgrades:
  - checkstyle 12.0.1 -> 12.1.1
  - exec-maven-plugin from 3.6.1 to 3.6.2
  - groovy.version 5.0.1 -> 5.0.2
  - maven-antrun-plugin) 3.1.0 -> 3.2.0
  - maven-release 3.1.1 -> 3.2.0
  - maven-war-plugin 3.4.0 -> 3.5.0


## [6.1.13] - 2025-10-12

### Changed

- Maven plugin upgrades:
  - checkstyle 12.0.0 -> 12.0.1
  - groovy.version 3.0.25 -> 5.0.1
  - jacoco-maven-plugin 0.8.13 -> 0.8.14
  - japicmp-maven-plugin 0.24.1 -> 0.24.2


## [6.1.12] - 2025-10-10

### Fixed
- align formatter setting with checkstyle rules

### Changed

- Maven plugin upgrades:
  - central-publishing-maven-plugin 0.8.0 -> 0.9.0
  - checkstyle from 11.1.0 -> 12.0.0
  - exec-maven-plugin from 3.5.1 -> 3.6.1
  - extra-enforcer-rules 1.10.0 -> 1.11.0
  - japicmp-maven-plugin 0.23.1 -> 0.24.1
  - maven-dependency-plugin 3.8.1 -> 3.9.0
  - maven-enforcer-plugin from 3.6.1 -> 3.6.2


## [6.1.11] - 2025-09-29

### Changed

- upgrade Eclipse Java Compiler 3.41.0 -> 3.43.0
- Maven plugin upgrades:
  - central-publishing-maven-plugin 0.7.0 -> 0.8.0
  - checkstyle 10.25.0 -> 11.1.0
  - flatten-maven-plugin 1.7.0 -> 1.7.3
  - formatter-maven-plugin 2.26.0 -> 2.29.0
  - gmavenplus-plugin 4.2.0 -> 4.2.1
  - license-maven-plugin 2.5.0 -> 2.7.0
  - maven-compiler-plugin 3.14.0 -> 3.14.1
  - maven-ear-plugin 3.3.0 -> 3.4.0
  - maven-enforcer-plugin 3.5.0 -> 3.6.1
  - maven-javadoc-plugin 3.11.2 -> 3.12.0
  - maven-scm-plugin 2.1.0 -> 2.2.1
  - maven-shade-plugin 3.6.0 -> 3.6.1
  - maven.surefire.version 3.5.3 -> 3.5.4
  - versions-maven-plugin 2.18.0 -> 2.19.1


## [6.1.10] - 2025-06-07

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.6.0 -> 3.6.1
  - checkstyle 10.23.0 -> 10.25.0
  - exec-maven-plugin 3.5.0 -> 3.5.1
  - gmavenplus-plugin 4.1.1 -> 4.2.0
  - groovy.version 3.0.24 -> 3.0.25
  - maven-clean-plugin 3.4.1 -> 3.5.0


## [6.1.9] - 2025-04-15

### Fixed
- versions-maven-plugin doesn't ignore *-rc* release candidates

### Changed
- calculate project.build.outputTimestamp based on last commit date
- Maven plugin upgrades:
  - checkstyle 10.22.0 -> 10.23.0
  - jacoco-maven-plugin from 0.8.12 -> 0.8.13


## [6.1.8] - 2025-04-01

### Changed
- upgrade Eclipse Java Compiler 3.40.0 -> 3.41.0
- Maven plugin upgrades:
  - extra-enforcer-rules 1.9.0 -> 1.10.0


## [6.1.7] - 2025-03-31

### Changed
- change checkstyle config to allow compact single-line JavaDoc
- Maven plugin upgrades:
  - checkstyle 10.21.2 -> 10.22.0
  - groovy.version 3.0.23 -> 3.0.24
  - flatten-maven-plugin 1.6.0 -> 1.7.0
  - formatter-maven-plugin 2.25.0 -> 2.26.0
  - maven.surefire.version 3.5.2 -> 3.5.3
  - maven-deploy-plugin 3.1.3 -> 3.1.4
  - maven-install-plugin 3.1.3 -> 3.1.4
  - maven-project-info-reports-plugin 3.8.0 -> 3.9.0


## [6.1.6] - 2025-02-22

### Changed
- Maven plugin upgrades:
  - checkstyle 10.21.0 -> 10.21.2
  - central-publishing-maven-plugin 0.6.0 -> 0.7.0
  - formatter-maven-plugin 2.24.1 -> 2.25.0
  - gmavenplus-plugin 4.0.1 -> 4.1.1
  - japicmp 0.23.0 -> 0.23.1
  - maven-clean-plugin 3.4.0 -> 3.4.1
  - maven-compiler-plugin 3.13.0 -> 3.14.0


## [6.1.5] - 2024-12-18

### Changed
- upgrade Eclipse Java Compiler 3.39.0 -> 3.40.0
- Maven plugin upgrades:
  - checkstyle 10.20.1 -> 10.21.0
  - jrebel-maven-plugin 1.2.0 -> 1.2.1
  - license-maven-plugin 2.4.0 -> 2.5.0
  - maven-bundle-plugin 5.1.9 -> 6.0.0
  - maven-javadoc-plugin 3.11.1 -> 3.11.2
  - versions-maven-plugin 2.17.1 -> 2.18.0


## [6.1.4] - 2024-11-08

### Changed
- Maven plugin upgrades:
  - checkstyle 10.18.2 -> 10.20.1
  - exec-maven-plugin 3.4.1 -> 3.5.0
  - junit-bom 5.11.2 -> 5.11.3
  - maven-checkstyle-plugin 3.5.0 -> 3.6.0.
  - maven-dependency-plugin 3.8.0 -> 3.8.1
  - maven-javadoc-plugin 3.10.1 -> 3.11.1
  - maven-project-info-reports-plugin 3.7.0 -> 3.8.0
  - maven-site-plugin 3.20.0 -> 3.21.0
  - maven.surefire.version 3.5.1 -> 3.5.2
  - taglist-maven-plugin 3.1.0 -> 3.2.1


## [6.1.3] - 2024-10-09

### Changed
- upgrade Eclipse Java Compiler 3.38.0 -> 3.39.0


## [6.1.2] - 2024-10-08

### Changed
- Maven plugin upgrades:
  - central-publishing-maven-plugin 0.5.0 -> 0.6.0
  - checkstyle 10.18.1 -> 10.18.2
  - doxia-module-markdown 1.12.0 -> 2.0.0
  - extra-enforcer-rules 1.8.0 -> 1.9.0
  - gmavenplus-plugin 3.0.2 -> 4.0.1
  - maven-javadoc-plugin 3.10.0 -> 3.10.1
  - maven.surefire.version 3.5.0 -> 3.5.1


## [6.1.1] - 2024-09-19

### Change
- relax javadoc `-Xdoclint` option from `all` to `reference,syntax`


## [6.1.0] - 2024-09-10

### Change
- configure ecj to use .settings/org.eclipse.jdt.core.prefs when present


## [6.0.0] - 2024-09-10

### Fix
- licenses of test dependencies in third-party file
- "Reference to undefined variable jacoco.xyz" when running J-Unit tests in Eclipse

### Change
- migrate from nexus-staging-maven-plugin to central-publishing-maven-plugin
- rename THIRD-PARTY.txt to META-INF/LICENSE.THIRD-PARTY.txt in final jar
- Maven plugin upgrades:
  - depcheck-maven-plugin 2.0.1 -> 2.0.2


## [5.1.0] - 2024-09-07

### Fix
- test classes are not compiled

### Changed
- set failIfNoTests to `true` by default
- introduce failIfNoITests with default `false`
- replaced deprecated **com.github.github:site-maven-plugin** with **maven-scm-publish-plugin**


## [5.0.0] - 2024-09-06

### Changed
- always use the same JDK for compiling unit tests as for library code (only allow changing of JDK for running tests)
- by default use the same Java version for running integration tests as for unit tests

### Added
- allow configuring different JDK for `verify` phase


## [4.0.2] - 2024-09-06

### Fixed
- overriding of `java.version`/`java.vendor` on command line does not work


## [4.0.1] - 2024-09-06

### Added
- make formatter line ending configurable through `formatter.lineending` and `formatter.validate.lineending`

### Changed
- Maven plugin upgrades:
  - checkstyle 10.17.0 -> 10.18.1


## [4.0.0] - 2024-09-05

### Added
- enable automatic source code validation via formatter-maven-plugin

### Changed
- set default Java version to 17
- update Eclipse Formatter settings (e.g. reduce max line length from 160 to 140)
- Maven plugin upgrades:
  - exec-maven-plugin from 3.3.0 -> 3.4.1
  - maven.surefire.version 3.3.1 -> 3.5.0
  - maven-deploy-plugin 3.1.2 -> 3.1.3
  - maven-install-plugin 3.1.2 -> 3.1.3
  - maven-checkstyle-plugin 3.4.0 -> 3.5.0
  - maven-javadoc-plugin 3.8.0 -> 3.10.0
  - maven-site-plugin 3.12.1 -> 3.20.0
  - maven-project-info-reports-plugin 3.6.2 -> 3.7.0
  - maven-dependency-plugin 3.7.1 -> 3.8.0


## [3.1.7] - 2024-08-09

### Changed
- Maven plugin upgrades:
  - groovy.version 3.0.21 -> 3.0.22
  - japicmp-maven-plugin 0.21.2 -> 0.22.0
  - maven-javadoc-plugin 3.7.0 -> 3.8.0
  - maven-release-plugin 3.1.0 -> 3.1.1
  - maven-project-info-reports-plugin 3.6.0 -> 3.6.2
  - maven.surefire.version 3.3.0 -> 3.3.1
  - taglist-maven-plugin 3.0.0 -> 3.1.0
  - versions-maven-plugin 2.16.2 -> 2.17.1


## [3.1.6] - 2024-06-25

### Changed
- Maven plugin upgrades:
  - maven-clean-plugin 3.3.2 -> 3.4.0
  - maven-dependency-plugin 3.7.0 -> 3.7.1
  - maven-jar-plugin 3.4.1 -> 3.4.2
  - maven-project-info-reports-plugin 3.5.0 -> 3.6.0
  - maven-release-plugin 3.0.1 -> 3.1.0
  - maven.surefire.version 3.2.5 -> 3.3.0


## [3.1.5] - 2024-06-12

### Fixed
- correct maven-jar-plugin to 3.4.1 from non-existing 3.5.0


## [3.1.4] - 2024-06-12

### Changed
- upgrade Eclipse Java Compiler 3.37.0 -> 3.38.0
- Maven plugin upgrades:
  - checkstyle 10.16.0 -> 10.17.0
  - formatter-maven-plugin 2.23.0 -> 2.24.1
  - maven-checkstyle-plugin 3.3.1 -> 3.4.0
  - maven-dependency-plugin 3.6.1 -> 3.7.0
  - maven-enforcer-plugin 3.4.1 -> 3.5.0
  - maven-javadoc-plugin 3.6.3 -> 3.7.0
  - maven-shade-plugin 3.5.3 -> 3.6.0
  - nexus-staging-maven-plugin 1.6.13 -> 1.7.0


## [3.1.3] - 2024-05-24

### Fixed
- maven-deploy-plugin warning: Using legacy syntax for alternative repository

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.5.0 -> 3.6.0
  - checkstyle 10.15.0 -> 10.16.0
  - exec-maven-plugin 3.2.0 -> 3.3.0
  - jacoco-maven-plugin from 0.8.11 -> 0.8.12
  - japicmp-maven-plugin 0.20.0 -> 0.21.2
  - maven-deploy-plugin 3.1.1 -> 3.1.2
  - maven-install-plugin 3.1.1 -> 3.1.2
  - maven-jar-plugin 3.3.0 -> 3.4.1
  - maven-scm-plugin 2.0.1 -> 2.1.0
  - maven-shade-plugin 3.5.2 -> 3.5.3
  - maven-source-plugin 3.3.0 -> 3.3.1
  - maven-toolchains-plugin 3.1.0 -> 3.2.0


## [3.1.2] - 2024-04-02

### Changed
- upgrade Eclipse Java Compiler 3.36.0 -> 3.37.0
- Maven plugin upgrades:
  - checkstyle 10.13.0 -> 10.15.0
  - extra-enforcer-rules 1.7.0 -> 1.8.0
  - groovy.version 3.0.20 -> 3.0.21
  - japicmp-maven-plugin 0.18.53 -> 0.20.0
  - maven-assembly-plugin 3.6.0 -> 3.7.1
  - maven-compiler-plugin 3.12.0 -> 3.13.0


## [3.1.1] - 2024-02-27

### Fixed
- exclude module-info.java files from checkstyle

### Changed
- Maven plugin upgrades:
  - checkstyle 10.12.7 -> 10.13.0
  - exec-maven-plugin from 3.1.1 -> 3.2.0
  - japicmp-maven-plugin 0.18.3 -> 0.18.5
  - license-maven-plugin 2.3.0 -> 2.4.0
  - maven-shade-plugin 3.5.1 -> 3.5.2
  - sign-maven-plugin 1.0.1 -> 1.1.0


## [3.1.0] - 2024-01-19

### Added
- new Maven property `maximum.maven.version` evaluated by enforcer plugin
- specify versions-maven-plugin:ignoredVersions `.*-(alpha|beta|M|RC|SNAPSHOT)([-_0-9].*)?`

### Changed
- Maven plugin upgrades:
  - checkstyle 10.12.6 -> 10.12.7
  - flatten-maven-plugin 1.5.0 -> 1.6.0
  - maven.surefire.version 3.2.3 -> 3.2.5


## [3.0.18] - 2023-12-23

### Changed
- upgrade Eclipse Java Compiler 3.35.0 -> 3.36.0
- Maven plugin upgrades:
  - checkstyle 10.12.5 -> 10.12.6
  - groovy.version 3.0.19 -> 3.0.20
  - maven-compiler-plugin 3.11.0 -> 3.12.0
  - maven.surefire.version 3.2.2 -> 3.2.3


## [3.0.17] - 2023-12-04

### Changed
- upgrade Eclipse Java Compiler 3.34.0 -> 3.35.0
- remove "-noverify" argument surefire JVM config
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.4.0 -> 3.5.0
  - checkstyle 10.12.0 -> 10.12.5
  - depcheck-maven-plugin 2.0.0 -> 2.0.1
  - exec-maven-plugin from 3.1.0 -> 3.1.1
  - gmavenplus-plugin 3.0.0 -> 3.0.2
  - groovy.version 3.0.17 -> 3.0.19
  - jacoco-maven-plugin 0.8.10 -> 0.8.11
  - japicmp-maven-plugin 0.17.2 -> 0.18.2
  - license-maven-plugin 2.1.0 -> 2.3.0
  - maven-clean-plugin 3.3.1 -> 3.3.2
  - maven-dependency-plugin 3.6.0 -> 3.6.1
  - maven-enforcer-plugin 3.3.0 -> 3.4.1
  - maven-javadoc-plugin 3.5.0 -> 3.6.2
  - maven-project-info-reports-plugin 3.4.5 -> 3.5.0
  - maven-shade-plugin 3.5.0 -> 3.5.1
  - maven.surefire.version 3.1.0 -> 3.2.2
  - versions-maven-plugin 2.16.0 -> 2.16.1


## [3.0.16] - 2023-06-23

### Fixed
- automatically downgrade Eclipse Java Compiler 3.34.0 -> 3.33.0 if Java version selected by toolchain plugin is lower than 17


## [3.0.15] - 2023-06-23

### Changed
- upgrade Eclipse Java Compiler 3.33.0 -> 3.34.0
- Maven plugin upgrades:
  - checkstyle 10.11.0 -> 10.12.0
  - extra-enforcer-rules 1.6.2 -> 1.7.0
  - formatter-maven-plugin 2.22.0 -> 2.23.0
  - jrebel-maven-plugin 1.1.11 -> 1.2.0
  - license-maven-plugin 2.0.1 -> 2.1.0
  - maven-clean-plugin 3.2.0 -> 3.3.1
  - maven-project-info-reports-plugin 3.4.3 -> 3.4.5
  - maven-release-plugin 3.0.0 -> 3.0.1
  - maven-shade-plugin 3.4.1 -> 3.5.0
  - maven-war-plugin 3.3.2 -> 3.4.0
  - maven.surefire.version 3.1.0 -> 3.1.2
  - versions-maven-plugin 2.15.0 -> 2.16.0


## [3.0.14] - 2023-05-26

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.3.0 -> 3.4.0
  - checkstyle 10.8.1 -> 10.11.0
  - extra-enforcer-rules 1.6.1 -> 1.6.2
  - flatten-maven-plugin 1.4.1 -> 1.5.0
  - gmavenplus-plugin 2.1.0 -> 3.0.0
  - groovy.version 3.0.16 -> 3.0.17
  - license-maven-plugin 2.0.0 -> 2.0.1
  - maven-assembly-plugin 3.5.0 -> 3.6.0
  - maven-bundle-plugin 5.1.8 -> 5.1.9
  - maven-checkstyle-plugin 3.2.2 -> 3.3.0
  - maven-dependency-plugin 3.5.0 -> 3.6.0
  - maven-scm-plugin 2.0.0 -> 2.0.1
  - maven-source-plugin 3.2.1 -> 3.3.0
  - maven.surefire.version 3.0.0 -> 3.1.0


## [3.0.13] - 2023-05-03

### Changed
- upgrade Eclipse Java Compiler 3.32.0 -> 3.33.0
- Maven plugin upgrades:
  - checkstyle 10.8.0 -> 10.8.1
  - flatten-maven-plugin 1.3.0 -> 1.4.1
  - groovy.version 3.0.15 -> 3.0.16
  - jacoco-maven-plugin 0.8.8 -> 0.8.10
  - jrebel-maven-plugin 1.1.10 -> 1.1.11
  - maven-checkstyle-plugin 3.2.1 -> 3.2.2
  - maven-deploy-plugin 3.1.0 -> 3.1.1
  - maven-enforcer-plugin 3.2.1 -> 3.3.0
  - maven-install-plugin 3.1.0 -> 3.1.1
  - maven-project-info-reports-plugin 3.4.2 -> 3.4.3
  - maven-release-plugin 3.0.0-M7 -> 3.0.0
  - maven-resources-plugin 3.3.0 -> 3.3.1
  - maven-scm-plugin 1.13.0 -> 2.0.0
  - maven-scm-provider-svnjava 2.2.1 -> 2.3.0
  - maven-surefire-plugin 2.22.2 -> 3.0.0


## [3.0.12] - 2023-03-04

### Changed
- Maven plugin upgrades:
  - japicmp-maven-plugin 0.17.1 -> 0.17.2
  - checkstyle 10.4 -> 10.8.0
  - doxia-module-markdown 1.11.1 -> 1.12.0
  - formatter-maven-plugin 2.21.0 -> 2.22.0
  - groovy.version 3.0.14 -> 3.0.15
  - maven-assembly-plugin 3.4.2 -> 3.5.0
  - maven-checkstyle-plugin 3.2.0 -> 3.2.1
  - maven-compiler-plugin 3.10.1 -> 3.11.0
  - maven-dependency-plugin 3.4.0 -> 3.5.0
  - maven-deploy-plugin 2.8.2 -> 3.1.0
  - maven-enforcer-plugin 3.1.0 -> 3.2.1
  - maven-install-plugin 2.5.2 -> 3.1.0
  - maven-javadoc-plugin 3.4.1 -> 3.5.0
  - maven-project-info-reports-plugin 3.4.1 -> 3.4.2
  - versions-maven-plugin 2.14.2 -> 2.15.0


## [3.0.11] - 2022-12-29

### Changed
- upgrade Eclipse Java Compiler 3.31.0 -> 3.32.0
- Maven plugin upgrades:
  - groovy.version 3.0.13 -> 3.0.14
  - checkstyle 10.0 -> 10.4.0
  - japicmp-maven-plugin 0.16.0 -> 0.17.1
  - os-maven-plugin 1.7.0 -> 1.7.1
  - sevntu-checks 1.42.0 -> 1.44.1
  - versions-maven-plugin 2.13.0 -> 2.14.2
  - maven.wagon.version 3.5.2 -> 3.5.3


## [3.0.10] - 2022-05-11

### Changed
- configure build-helper-maven-plugin:parse-version
- Maven plugin upgrades:
  - formatter-maven-plugin 2.20.0 -> 2.21.0
  - gmavenplus-plugin 2.0.0 -> 2.1.0
  - maven-ear-plugin 3.2.0 -> 3.3.0
  - maven-release-plugin 2.5.3 -> 3.0.0-M7
  - maven-shade-plugin 3.4.0 -> 3.4.1
  - versions-maven-plugin 2.12.0 -> 2.13.0


## [3.0.9] - 2022-10-17

### Fix
- custom.manifestTemplateFile property not working with multi-module projects

### Changed
- set Maven property `m2e.apt.activation=jdt_apt` to enable annotation processing in Eclipse by default
- configure M2E lifecycle mapping for more build-helper-maven-plugin goals
- Maven plugin upgrades:
  - gmavenplus-plugin 1.13.1 -> 2.0.0


## [3.0.8] - 2022-10-06

### Fix
- delete-java-stubs@process-classes goal fails because of syntax error


## [3.0.7] - 2022-10-06

### Fix
- delete-java-stubs@process-classes goal fails if stub directories are missing in target/classes


## [3.0.6] - 2022-10-05

### Changed
- enable execution of gmavenplus plugin from within eclipse on full builds
- change delete-java-stubs@process-classes to only delete class files from target/classes and not resource files


## [3.0.5] - 2022-10-01

### Changed
- increase minimum required Maven version -> 3.6.3
- upgrade Eclipse Java Compiler 3.30.0 -> 3.31.0
- Maven plugin upgrades:
  - groovy.version 3.0.12 -> 3.0.13
  - japicmp-maven-plugin 0.15.7 -> 0.16.0
  - maven-checkstyle-plugin 3.1.2 -> 3.2.0
  - maven-jar-plugin 3.2.2 -> 3.3.0
  - maven-shade-plugin 3.3.0 -> 3.4.0
  - versions-maven-plugin 2.11.0 -> 2.12.0


## [3.0.4] - 2022-08-17

### Fixed
- building Java artifacts fails `Unrecognized option : <path>\src\main\java` if source directory does not exist

### Changed
- Maven plugin upgrades:
  - flatten-maven-plugin 1.2.7 -> 1.3.0
  - maven-javadoc-plugin 3.4.0 -> 3.4.1
  - maven-project-info-reports-plugin 3.4.0 -> 3.4.1
- Maven plugin downgrades:
  - maven-deploy-plugin 3.0.0 -> 2.8.2 because of [MINSTALL-151](https://issues.apache.org/jira/browse/MINSTALL-151)
  - maven-install-plugin 3.0.1 -> 2.5.2 because of [MINSTALL-151](https://issues.apache.org/jira/browse/MINSTALL-151)


## [3.0.3] - 2022-08-13

### Changed
- Disable InnerAssignment checkstyle rule
- Maven plugin upgrades:
  - maven-bundle-plugin 5.1.7 -> 5.1.8
  - maven-site-plugin 3.12.0 -> 3.12.1


## [3.0.2] - 2022-07-28

### Changed
- upgrade Eclipse Java Compiler 3.29.0 -> 3.30.0
- move maven-enforcer-plugin/requirePluginVersions config to separate plugin execution
- Maven plugin upgrades:
  - depcheck-maven-plugin 1.0.0 -> 2.0.0
  - exec-maven-plugin 3.0.0 -> 3.1.0
  - extra-enforcer-rules 1.5.1 -> 1.6.1
  - formatter-maven-plugin 2.19.0 -> 2.20.0
  - groovy.version 3.0.11 -> 3.0.12
  - maven-assembly-plugin 3.3.0 -> 3.4.2
  - maven-bundle-plugin 5.1.6 -> 5.1.7
  - maven-deploy-plugin 2.8.2 -> 3.0.0
  - maven-install-plugin 2.5.2 -> 3.0.1
  - maven-project-info-reports-plugin 3.3.0 -> 3.4.0
  - maven-resources-plugin 3.2.0 -> 3.3.0
  - maven.wagon.version 3.5.1 -> 3.5.2


## [3.0.1] - 2022-06-21

### Changed
- Maven plugin upgrades:
  - checkstyle 9.3 -> 10.0
  - formatter-maven-plugin 2.18.0 -> 2.19.0
  - maven-antrun-plugin 3.0.0 -> 3.1.0
  - maven-bundle-plugin 5.1.5 -> 5.1.6
  - maven-enforcer-plugin 3.0.0 -> 3.1.0
  - maven-ejb-plugin 3.1.0 -> 3.2.1
  - maven-javadoc-plugin 3.3.2 to
  - maven-project-info-reports-plugin 3.2.2 -> 3.3.0
  - maven-release-plugin 2.5.3 -> 3.0.0-M6
  - maven-scm-plugin 1.12.2 -> 1.13.0
  - maven-scm-provider-svnjava 2.1.2 -> 2.2.1
  - maven-site-plugin 3.11.0 -> 3.12.0
  - maven-toolchains-plugin 3.0.0 -> 3.1.0
  - nexus-staging-maven-plugin 1.6.8 -> 1.6.13
- upgrading gmavenplus-plugin's groovy -> 3.0.11


## [3.0.0] - 2022-04-14

### Changed
- require Java 11 or higher
- upgrade Eclipse Java Compiler 3.26.0 -> 3.29.0
- Maven plugin upgrades:
  - checkstyle 9.1 -> 9.3
  - jacoco-maven-plugin 0.8.7 -> 0.8.8
  - maven-clean-plugin 3.1.0 -> 3.2.0
  - maven-shade-plugin 3.2.4 -> 3.3.0


## [2.5.3] - 2022-03-18

### Changed
- Maven plugin upgrades:
  - formatter-maven-plugin 2.17.1 -> 2.18.0
  - japicmp-maven-plugin 0.15.6 -> 0.15.7
  - maven-compiler-plugin 3.10.0 -> 3.10.1
  - maven-dependency-plugin from. 3.2.0 -> 3.3.0
  - maven-project-info-reports-plugin 3.2.1 -> 3.2.2
  - sign-maven-plugin 1.0.0 -> 1.0.1
  - versions-maven-plugin 2.9.0 -> 2.10.0
- upgrading gmavenplus-plugin's groovy -> 3.0.10


## [2.5.2] - 2022-02-23

### Added
- property `maven-bundle-plugin.export-packages.no-uses`


## [2.5.1] - 2022-02-22

### Added
- add NoWhitespaceBeforeCaseDefaultColon checkstyle check

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.2.0 -> 3.3.0
  - checkstyle 8.44 -> 9.1
  - doxia-module-markdown 1.10 -> 1.11.1
  - extra-enforcer-rules 1.4 -> 1.5.1
  - formatter-maven-plugin 2.16.0 -> 2.17.1
  - gmavenplus-plugin 1.13.0 -> 1.13.1
  - japicmp-maven-plugin 0.15.3 -> 0.15.6
  - maven-bundle-plugin 5.1.2 -> 5.1.4
  - maven-compiler-plugin 3.8.1 -> 3.10.0
  - maven-jar-plugin 3.2.0 -> 3.2.2
  - maven-javadoc-plugin 3.3.1 -> 3.3.2
  - maven-project-info-reports-plugin 3.1.2 -> 3.2.1
  - maven-scm-plugin 1.12.0 -> 1.12.2
  - maven-site-plugin 3.9.1 -> 3.11.0
  - maven-wagon 3.4.3 -> 3.5.1
  - sevntu-checks 1.40.0 -> 1.41.0
  - sign-maven-plugin 0.3.1 -> 1.0.0
  - taglist-maven-plugin 2.4 -> 3.0.0
  - versions-maven-plugin 2.8.1 -> 2.9.0


## [2.4.35] - 2021-09-30

### Changed
- downgrading Eclipse Java Compiler from 3.27.0 to 3.26.0 for now since newer versions require JDK 11+


## [2.4.34] - 2021-09-30

### Added
- add maven-bundle-plugin.[private|import]-package properties

### Changed
- upgrade Eclipse Java Compiler from 3.25.0 to 3.27.0


## [2.4.33] - 2021-09-28

### Changed
- Maven plugin upgrades:
  - extra-enforcer-rules 1.3 -> 1.4
  - maven-enforcer-plugin 3.0-M3 -> 3.0
  - maven-javadoc-plugin 3.3.0 -> 3.3.1
  - maven-scm-plugin 1.11.3 -> 1.12.0
- upgrading gmavenplus-plugin's groovy -> 3.0.9


## [2.4.32] - 2021-08-17

### Changed
- rely on Maven Bundle Plugin to calculate Bundle-SymbolicName
- Maven plugin upgrades:
  - checkstyle 8.43 -> 8.44
  - maven-scm-plugin 1.11.2 -> 1.11.3


## [2.4.31] - 2021-07-07

### Changed
- change Checkstyle rule Indentation.lineWrappingIndentation from 3 to 0
- Maven plugin upgrades:
  - checkstyle 8.39 -> 8.43
  - doxia-module-markdown 1.9.1 -> 1.10
  - formatter-maven-plugin 2.14.0 -> 2.16.0
  - jacoco-maven-plugin 0.8.6 -> 0.8.7
  - maven-dependency-plugin 3.1.2 -> 3.2.0
  - maven-javadoc-plugin 3.2.0 -> 3.3.0
  - maven-project-info-reports-plugin 3.1.1 -> 3.1.2
  - sevntu-checks 1.39.0 -> 1.40.0
- upgrading gmavenplus-plugin's groovy -> 3.0.8


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
  - checkstyle 8.36.2 -> 8.39
  - flatten-maven-plugin 1.2.5 -> 1.2.7
  - formatter-maven-plugin 2.14.0 -> 2.15.0
  - japicmp-maven-plugin 0.15.2 -> 0.15.3
  - maven-bundle-plugin 5.1.1 -> 5.1.2
  - sevntu-checks 1.38.0 -> 1.39.0
  - sign-maven-plugin 0.3.0 -> 0.3.1


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
  - maven-wagon 3.4.2 -> 3.4.3


## [2.4.26] - 2021-02-24

### Fixed
- sign-maven-plugin is executed before maven-sources-plugin and maven-javadoc-plugin


## [2.4.25] - 2021-02-21

### Fixed
- additional source paths are ignored during compilation

### Changed
- publish to Maven Central instead of Bintray because of its [termination](https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter/)
- Maven plugin upgrades:
  - checkstyle 8.35 -> 8.36.2
  - os-maven-plugin 8.35 -> 8.36.1
  - maven-checkstyle-plugin 3.1.1 -> 3.1.2
  - formatter-maven-plugin 2.13.0 -> 2.14.0


## [2.4.24] - 2021-01-24

### Fixed
- "Error assembling JAR: Manifest file: target/classes/META-INF/MANIFEST.MF does not exist." when building Maven plugins.

### Added
- check to prevent dependencies licensed under GPL

### Changed
- minimum required Maven version is now 3.5.4
- upgrade to Eclipse Java Compiler 3.24.0
- Maven plugin upgrades:
  - japicmp-maven-plugin 0.15.1 -> 0.15.2
  - maven-resources-plugin 3.1.0 -> 3.2.0


## [2.4.22] - 2021-01-05

### Added
- run **maven-toolchains-plugin:toolchain** goal in validate phase
- Maven plugin upgrades:
  - gmavenplus-plugin 1.11.0 -> 1.12.1
  - japicmp-maven-plugin 0.14.4 -> 0.15.1
  - maven-ear-plugin 3.1.0 -> 3.2.0
  - maven-wagon 3.4.1 -> 3.4.2
- upgrading gmavenplus-plugin's groovy to 3.0.7


## [2.4.21] - 2020-11-07

### Changed
- upgrade to Eclipse Java Compiler 3.23.0
- support toolchain aware compilation of Java 9+ Maven projects with Eclipse Java Compiler


## [2.4.19] - 2020-11-06

### Changed
- migrate from Travis CI to GitHub Actions
- Maven plugin upgrades:
  - sevntu-checks 1.37.1 -> 1.38.0


## [2.4.18] - 2020-11-01

### Changed
- downgrading maven-resources-plugin from 3.2.0 to 3.1.0 as new version is broken


## [2.4.17] - 2020-11-01

### Added
- fast-build profile that skips checks and tests
- maven property `project.build.outputTimestamp` to set the modification timestamp of all classes in the final jar match the build timestamp

### Changed
- Maven plugin upgrades:
  - checkstyle 8.32 -> 8.35
  - build-helper-maven-plugin 3.1.0 -> 3.2.0
  - exec-maven-plugin 1.6.0 -> 3.0.0
  - extra-enforcer-rules 1.2 -> 1.3
  - flatten-maven-plugin 1.2.2 -> 1.2.4
  - formatter-maven-plugin 2.11.0 -> 2.13.0
  - gmavenplus-plugin 1.8.1 -> 1.11.0
  - jacoco-maven-plugin 0.8.5 -> 0.8.6
  - japicmp-maven-plugin 0.14.3 -> 0.14.4
  - maven-assembly-plugin 3.2.0 -> 3.3.0
  - maven-bundle-plugin 4.2.1 -> 5.1.1
  - maven-ear-plugin 3.0.2 -> 3.1.0
  - maven-ejb-plugin 3.0.1 -> 3.1.0
  - maven-project-info-reports-plugin 3.0 -> 3.1.1
  - maven-shade-plugin 3.2.3 -> 3.2.4
  - maven-site-plugin 3.9.0 -> 3.9.1
  - maven-war-plugin 3.2.3 -> 3.3.1
  - maven-wagon 3.4.0 -> 3.4.1
- upgrade to Eclipse Java Compiler 3.22.0
- upgrading gmavenplus-plugin's groovy to 3.0.6


## [2.4.16] - 2020-05-11

### Changed
- set maven-release-plugin `<checkModificationExclude>pom.xml</checkModificationExclude>`
- Maven plugin upgrades:
  - checkstyle 8.30 -> 8.31


## [2.4.15] - 2020-04-27

### Changed
- use Sevntu's [LineLengthExtendedCheck](https://github.com/sevntu-checkstyle/sevntu.checkstyle/blob/master/sevntu-checks/src/main/java/com/github/sevntu/checkstyle/checks/sizes/LineLengthExtendedCheck.java) instead of Checkstyle's [LineLengthCheck](https://github.com/checkstyle/checkstyle/blob/master/src/main/java/com/puppycrawl/tools/checkstyle/checks/sizes/LineLengthCheck.java) for Java source code to workaround [Checkstyle issue #7460](https://github.com/checkstyle/checkstyle/issues/7460)
- upgrade to Eclipse Java Compiler 3.21.0
- Maven plugin upgrades:
  - maven-antrun-plugin 1.8 -> 3.0.0


## [2.4.14] - 2020-04-15

### Changed
- set maven-install-plugin `installAtEnd` to `true`
- set maven-deploy-plugin `deployAtEnd` to `true`
- Maven plugin upgrades:
  - maven-shade-plugin 3.2.2 -> 3.2.3
  - gmavenplus-plugin 1.8.1 -> 1.9.0
  - flatten-maven-plugin 1.2.1 -> 1.2.2


## [2.4.13] - 2020-03-21

### Changed
- Maven plugin upgrades:
  - build-helper-maven-plugin 3.0.0 -> 3.1.0
  - checkstyle 8.27 -> 8.30
  - dependency-scope-maven-plugin 0.10
  - flatten-maven-plugin 1.2.1
  - japicmp-maven-plugin 0.14.3
  - maven-checkstyle-plugin 3.1.0 -> 3.1.1
  - maven-dependency-plugin 3.1.1 -> 3.1.2
  - maven-javadoc-plugin 3.1.1 -> 3.2.0
  - maven-shade-plugin 3.2.1 -> 3.2.2
  - maven-site-plugin 3.8.2 -> 3.9.0
  - maven-source-plugin 3.2.0 -> 3.2.1
  - sevntu-checks 1.36.0 -> 1.37.1
- removed deprecated checkstyle rules JavadocMethod.allowMissingThrowsTags/allowUndeclaredRTE/allowThrowsTagsForSubclasses/suppressLoadErrors, see https://github.com/checkstyle/checkstyle/issues/7329


## [2.4.10] - 2019-12-20

### Changed
- apply checkstyle LineLengthCheck only to java,js,xml files


## [2.4.8] - 2019-12-20

### Changed
- add `-Djava.rmi.server.hostname=localhost` to surefire-plugin config
- upgrade to Eclipse Compiler 3.20.0
- Maven plugin upgrades:
  - checkstyle 8.20 -> 8.27
  - gmavenplus-plugin 1.7.1 -> 1.8.1
  - jacoco-maven-plugin 0.8.4 -> 0.8.5
  - japicmp-maven-plugin 0.14.2
  - maven-assembly-plugin 3.1.1 -> 3.2.0
  - maven-ear-plugin 3.0.1 -> 3.0.2
  - maven-enforcer-plugin 3.0-M3
  - maven-jar-plugin 3.1.2 -> 3.2.0
  - maven-source-plugin 3.1.0 -> 3.2.0
  - maven-wagon 3.3.4
  - sevntu-checks 1.35.0 -> 1.36.0


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
