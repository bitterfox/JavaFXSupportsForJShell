#!/bin/sh

#JAVA_HOME=

PROJ_ROOT=.

cd $PROJ_ROOT; $JAVA_HOME/bin/javac --source-path "src/main/java" -d "target/classes" src/main/java/module-info.java

