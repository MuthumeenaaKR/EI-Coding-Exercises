
package com.eicoding.exercise2.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ScheduleManager {
    // Singleton
    private static volatile ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) instance = new ScheduleManager();
            }
        }
        return instance;
    }

    public void addObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }
    private void publish(String msg) { for (Observer o : observers) o.notify(msg); }

    public synchronized void addTask(Task t) {
        // check for overlaps
        Optional<Task> conflict = tasks.stream().filter(existing -> existing.overlapsWith(t)).findFirst();
        if (conflict.isPresent()) {
            String message = "Task '" + t.getDescription() + "' conflicts with existing task '" + conflict.get().getDescription() + "'.";
            publish(message);
            throw new IllegalArgumentException(message);
        }
        tasks.add(t);
        ConsoleLogger.getLogger().info("Task added: " + t);
    }

    public synchronized void removeTask(String description) {
        Optional<Task> found = tasks.stream().filter(t -> t.getDescription().equalsIgnoreCase(description)).findFirst();
        if (found.isPresent()) {
            tasks.remove(found.get());
            ConsoleLogger.getLogger().info("Task removed: " + found.get());
        } else {
            throw new IllegalArgumentException("Task not found: " + description);
        }
    }

    public synchronized List<Task> getTasksSorted() {
        List<Task> copy = new ArrayList<>(tasks);
        Collections.sort(copy);
        return copy;
    }

    public synchronized void markCompleted(String description) {
        Optional<Task> found = tasks.stream().filter(t -> t.getDescription().equalsIgnoreCase(description)).findFirst();
        if (found.isPresent()) {
            found.get().setCompleted(true);
            ConsoleLogger.getLogger().info("Task marked completed: " + found.get());
        } else {
            throw new IllegalArgumentException("Task not found: " + description);
        }
    }
}
