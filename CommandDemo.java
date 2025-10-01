
package com.eicoding.exercise1.behavioral.command;

public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("--- Command Demo: Remote Control ---");
        Light living = new Light("Living Room");
        Light kitchen = new Light("Kitchen");
        RemoteControl remote = new RemoteControl();

        remote.setCommand("A", new LightOnCommand(living));
        remote.setCommand("B", new LightOffCommand(living));
        remote.setCommand("C", new LightOnCommand(kitchen));
        remote.setCommand("D", new LightOffCommand(kitchen));

        System.out.println("Press A (living on):");
        remote.press("A");
        System.out.println("Press C (kitchen on):");
        remote.press("C");
        System.out.println("Press B (living off):");
        remote.press("B");
    }
}
