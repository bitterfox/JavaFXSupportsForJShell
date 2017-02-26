package net.java.openjdk.shinyafox.jshell.jfxs;

import java.util.Map;
import jdk.jshell.execution.JdiExecutionControlProvider;
import jdk.jshell.spi.ExecutionControl;
import jdk.jshell.spi.ExecutionControlProvider;
import jdk.jshell.spi.ExecutionEnv;

public class JavaFXExecutionControlProvider implements ExecutionControlProvider {

    private ExecutionControlProvider delegate = new JdiExecutionControlProvider();

    public String name() {
        return "javafx";
    }

    public Map<String, String> defaultParameters() {
        return delegate.defaultParameters();
    }


    public ExecutionControl generate(ExecutionEnv env, Map<String, String> parameters) throws Throwable {
        Map<String, String> delegateParams = delegate.defaultParameters();
        delegateParams.put(JdiExecutionControlProvider.PARAM_REMOTE_AGENT, JavaFXRemoteExecutionControl.class.getName());

        delegateParams.putAll(parameters);

        return delegate.generate(env, delegateParams);
    }

}
