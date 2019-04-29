# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).


## [Unreleased]


## [2.2.1] - 2019-04-29

### Changed
- use "groovy-all" instead of "groovy-ant" plugin dependency for gmavenplus plugin
- Maven plugin upgrades:
  - checkstyle 8.20


## [2.2.0] - 2019-04-15

### Fixed
* Surefire tests may fail on Jenkins containers with latest OpenJDK8, see https://github.developer.allianz.io/azd/jenkins-slave-maven/issues/70

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