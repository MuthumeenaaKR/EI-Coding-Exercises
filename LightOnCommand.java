
package com.eicoding.exercise1.behavioral.command;

public class LightOnCommand implements Command {
    private final Light light;
    public LightOnCommand(Light light) { this.light = light; }
    @Override
    public void execute() { light.on(); }
}
