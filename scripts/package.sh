
#JAVA_HOME=
PROJ_ROOT=.

cd $PROJ_ROOT; $JAVA_HOME/bin/jar --create --file target/JavaFXSupportsForJShell.jar --module-version 1.0 -C target/classes .
