
package com.eicoding.exercise1.behavioral.command;

public class Light {
    private final String location;
    private boolean on = false;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        on = true;
        System.out.println(location + " light is ON");
    }

    public void off() {
        on = false;
        System.out.println(location + " light is OFF");
    }
}
