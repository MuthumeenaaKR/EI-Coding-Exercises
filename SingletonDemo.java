
package com.eicoding.exercise1.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("--- Singleton Demo: AppConfig ---");
        AppConfig cfg1 = AppConfig.getInstance();
        System.out.println("Initial config: " + cfg1);
        cfg1.setLogLevel(5);
        cfg1.setEnvironment("production");
        AppConfig cfg2 = AppConfig.getInstance();
        System.out.println("Config after modification via cfg1 (read via cfg2): " + cfg2);
    }
}
