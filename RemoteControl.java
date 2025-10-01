
package com.eicoding.exercise1.behavioral.command;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {
    private final Map<String, Command> buttons = new HashMap<>();

    public void setCommand(String button, Command cmd) {
        buttons.put(button, cmd);
    }

    public void press(String button) {
        Command cmd = buttons.get(button);
        if (cmd != null) cmd.execute();
        else System.out.println("No command assigned to button: " + button);
    }
}
