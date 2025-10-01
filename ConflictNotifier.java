
package com.eicoding.exercise2.scheduler;

public class ConflictNotifier implements Observer {
    @Override
    public void notify(String message) {
        System.out.println("[CONFLICT NOTIFICATION] " + message);
    }
}
