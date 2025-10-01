
package com.eicoding.exercise1.creational.singleton;

public class AppConfig {
    private static volatile AppConfig instance;
    private String environment;
    private int logLevel;

    private AppConfig() {
        this.environment = "development";
        this.logLevel = 1;
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }
    public int getLogLevel() { return logLevel; }
    public void setLogLevel(int logLevel) { this.logLevel = logLevel; }

    @Override
    public String toString() {
        return "AppConfig[env=" + environment + ", logLevel=" + logLevel + "]";
    }
}
