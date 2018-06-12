#!/usr/bin/env bash
#
# Copyright 2015-2018 by Vegard IT GmbH, Germany, https://vegardit.com
# SPDX-License-Identifier: Apache-2.0
# 
# @author Sebastian Thomschke, Vegard IT GmbH
# @author Patrick Spielmann, Vegard IT GmbH

set -e # abort script at first error
set -o pipefail # causes a pipeline to return the exit status of the last command in the pipe that returned a non-zero return value

if [[ -f ./release-config.sh ]]; then
    echo "Sourcing [./release-config.sh]..." 
    source ./release-config.sh
fi

MAVEN_VERSION=3.5.3
if [[ ! -e $HOME/.m2/bin/apache-maven-$MAVEN_VERSION ]]; then
    echo "Installing Maven version $MAVEN_VERSION..."
    mkdir -p $HOME/.m2/bin/
    wget --quiet https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -O /tmp/maven.tar.gz
    tar xfz /tmp/maven.tar.gz -C $HOME/.m2/bin/
fi
export M2_HOME=$HOME/.m2/bin/apache-maven-$MAVEN_VERSION
export PATH=$M2_HOME/bin:$PATH

# https://stackoverflow.com/questions/3545292/how-to-get-maven-project-version-to-the-bash-command-line
projectVersion="$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout)"

#
# decide whether to build/deploy a snapshot version or perform a release build
#
if [[ ${projectVersion:-foo} == ${POM_CURRENT_VERSION:-bar} ]]; then
    # https://stackoverflow.com/questions/8653126/how-to-increment-version-number-in-a-shell-script/21493080#21493080
    nextDevelopmentVersion="$(echo ${POM_RELEASE_VERSION} | perl -pe 's/^((\d+\.)*)(\d+)(.*)$/$1.($3+1).$4/e')-SNAPSHOT"
    echo "###################################################"
    echo "# Performing Maven Release...                     #"
    echo "###################################################"
    echo "         Current Version: ${projectVersion}"
    echo "         Release Version: ${POM_RELEASE_VERSION}"
    echo "Next Development Version: ${nextDevelopmentVersion}"
    echo "          Skipping Tests: ${SKIP_TESTS}"
    echo "              Is Dry-Run: ${DRY_RUN}"
    mavenArgs="-DdryRun=${DRY_RUN}"
    mavenArgs="${mavenArgs} -Darguments=\"-DskipTests=${SKIP_TESTS} -DskipITs=${SKIP_TESTS}\""
    mavenArgs="${mavenArgs} -DautoVersionSubmodules=true -DreleaseVersion=${POM_RELEASE_VERSION} -DdevelopmentVersion=${nextDevelopmentVersion}"
    mavenArgs="${mavenArgs} -Dresume=false release:clean release:prepare release:perform"
else
    echo "Building project version $projectVersion..."
    mavenArgs="deploy"
fi

MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1" # https://zeroturnaround.com/rebellabs/your-maven-build-is-slow-speed-it-up/
export MAVEN_OPTS="${MAVEN_OPTS} -Xmx1024m -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true"

mvn -e -U \
   --batch-mode \
   --show-version \
   --settings .travis/maven_settings.xml \
   --toolchains .travis/maven_toolchains.xml \
   help:active-profiles clean ${mavenArgs} \
   | grep -v -e "\[INFO\]  .* \[0.0[0-9][0-9]s\]" # the grep command suppresses all lines from maven-buildtime-extension that report plugins with execution time <=99ms
