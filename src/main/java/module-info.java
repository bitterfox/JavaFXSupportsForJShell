module net.java.openjdk.shinyafox.jshell.jfxs {
    requires jdk.jshell;
    requires javafx.graphics;

    exports net.java.openjdk.shinyafox.jshell.jfxs;

    provides jdk.jshell.spi.ExecutionControlProvider
        with net.java.openjdk.shinyafox.jshell.jfxs.JavaFXExecutionControlProvider;
}
