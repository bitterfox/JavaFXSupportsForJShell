package net.java.openjdk.shinyafox.jshell.jfxs;

import java.lang.reflect.Method;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;

import jdk.jshell.execution.RemoteExecutionControl;
import jdk.jshell.spi.ExecutionControlProvider;
import static jdk.jshell.execution.Util.forwardExecutionControlAndIO;

import javafx.application.Platform;

public class JavaFXRemoteExecutionControl extends RemoteExecutionControl {

    public static void main(String[] args) throws Exception {
        String loopBack = null;
        Socket socket = new Socket(loopBack, Integer.parseInt(args[0]));
        InputStream inStream = socket.getInputStream();
        OutputStream outStream = socket.getOutputStream();
        Map<String, Consumer<OutputStream>> outputs = new HashMap<>();
        outputs.put("out", st -> System.setOut(new PrintStream(st, true)));
        outputs.put("err", st -> System.setErr(new PrintStream(st, true)));
        Map<String, Consumer<InputStream>> input = new HashMap<>();
        input.put("in", System::setIn);
        Platform.startup(() -> {});
        Platform.setImplicitExit(false);
        forwardExecutionControlAndIO(new JavaFXRemoteExecutionControl(), inStream, outStream, outputs, input);
    }

    private static class ExceptionalValue<T> {
        T value;
        Exception ex;

        static <T> ExceptionalValue<T> of(T value) {
            ExceptionalValue<T> val = new ExceptionalValue<>();
            val.value = value;
            return val;
        }

        static <T> ExceptionalValue<T> failed(Exception ex) {
            ExceptionalValue<T> val = new ExceptionalValue<>();
            val.ex = ex;
            return val;
        }

        T get() throws Exception {
            if (ex == null) {
                return value;
            } else {
                throw ex;
            }
        }
    }

    protected String invoke(Method doitMethod) throws Exception {
        List<ExceptionalValue<String>> ret = new ArrayList<>();

        Platform.runLater(() -> {
                try {
                    String val = super.invoke(doitMethod);
                    ret.add(ExceptionalValue.of(val));
                } catch (Exception e) {
                    ret.add(ExceptionalValue.failed(e));
                }
            });

        return ret.isEmpty() ? "" : ret.get(0).get();
    }

}
