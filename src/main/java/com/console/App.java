package com.console;

import static com.console.ConsoleTransformer.scan;

public class App {
    public static void main(String[] args) throws Exception {
        LoggingController.loggingControllerMBeanServer();
        ConsoleTransformer consoleTransformer = new ConsoleTransformer();
        consoleTransformer.getConvertString();
        scan.close();
    }
}
