#JAVA_HOME=

PROJ_ROOT=.

J_MOD_PATH=$PROJ_ROOT/target/JavaFXSupportsForJShell.jar
R_MOD_PATH=$PROJ_ROOT/target/JavaFXSupportsForJShell.jar
STARTUP=$PROJ_ROOT/scripts/startup.jsh

$JAVA_HOME/bin/jshell -J--module-path -J$J_MOD_PATH -R--module-path -R$R_MOD_PATH --execution "javafx" --startup $STARTUP $@
