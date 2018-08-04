# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](http://semver.org/spec/v2.0.0.html).


## [Unreleased]

### Added
- checkstyle ignore filters for binary files

### Changed
- upgrade checkstyle to 8.11
- upgrade extra-enforcer-rules to 1.0-beta-9
- upgrade gmavenplus-plugin to 1.6.1
- upgrade maven-ear-plugin to 3.0.1
- upgrade maven-project-info-reports-plugin to 3.0.0
- upgrade maven-javadoc-plugin to 3.0.1
- upgrade maven-surefire-report-plugin to 2.22.0

### Removed
- checkstyle rule `UncommentedMain`


## [2.1.3] - 2018-06-28
- setting completionGoals `clean install -DskipTests=true` to workaround still present multi-module release issue [MRELEASE-271](https://issues.apache.org/jira/browse/MRELEASE-271)


## [2.1.2] - 2018-06-28
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