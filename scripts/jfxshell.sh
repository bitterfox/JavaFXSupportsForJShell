#JAVA_HOME=

J_MOD_PATH="./JavaFXSupportsForJShell.jar"
R_MOD_PATH="./JavaFXSupportsForJShell.jar"

$JAVA_HOME/bin/jshell -J--module-path -J$J_MOD_PATH -R--module-path -R$R_MOD_PATH --execution "javafx" $@

