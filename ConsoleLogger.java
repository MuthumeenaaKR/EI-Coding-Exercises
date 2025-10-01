
package com.eicoding.exercise2.scheduler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger {
    private static final ConsoleLogger INSTANCE = new ConsoleLogger();
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private ConsoleLogger() {}

    public static ConsoleLogger getLogger() { return INSTANCE; }

    public void info(String message) {
        System.out.println("[INFO " + LocalDateTime.now().format(DF) + "] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR " + LocalDateTime.now().format(DF) + "] " + message);
    }
}
