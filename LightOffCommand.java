
package com.eicoding.exercise1.behavioral.command;

public class LightOffCommand implements Command {
    private final Light light;
    public LightOffCommand(Light light) { this.light = light; }
    @Override
    public void execute() { light.off(); }
}
