package com.console;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class LoggingController implements LoggingControllerMBean {

    private LoggingAspect loggingAspect;

    public LoggingController(LoggingAspect loggingAspect) {
        this.loggingAspect = loggingAspect;
    }

    @Override
    public boolean isLoggingEnabled() {
        return LoggingAspect.isLoggingEnabled();
    }

    @Override
    public void setLoggingEnabled(boolean loggingEnabled) {
        LoggingAspect.setLoggingEnabled(loggingEnabled);
        System.out.println("Logging enabled: " + loggingEnabled);
    }

    public static void loggingControllerMBeanServer() throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ConsoleTransformer:type=LoggingController");
        LoggingAspect loggingAspect = new LoggingAspect();
        LoggingController controller = new LoggingController(loggingAspect);
        mbs.registerMBean(controller, name);
    }
}
