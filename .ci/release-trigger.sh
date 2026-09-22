#!/bin/sh
# shellcheck disable=SC2034  # Ignore unused variables

# this file is evaluated by shared workflow https://github.com/sebthom/gha-shared/blob/v1/.github/workflows/maven-build.yml

POM_CURRENT_VERSION="8.2.2-SNAPSHOT" # perform release if pom.xml matches this version
POM_RELEASE_VERSION="8.2.2" # next release version

DRY_RUN=false # is dry run?
SKIP_TESTS=true # skip tests during release build?
