
package com.eicoding.exercise2.scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private final String description;
    private final LocalTime start;
    private final LocalTime end;
    private final String priority;
    private boolean completed = false;

    private static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("HH:mm");

    public Task(String description, LocalTime start, LocalTime end, String priority) {
        if (start == null || end == null) throw new IllegalArgumentException("Start/end cannot be null");
        if (end.isBefore(start) || end.equals(start)) throw new IllegalArgumentException("End time must be after start time");
        this.description = Objects.requireNonNull(description);
        this.start = start;
        this.end = end;
        this.priority = Objects.requireNonNull(priority);
    }

    public String getDescription() { return description; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public boolean overlapsWith(Task other) {
        // overlap exists if start < other.end && other.start < end
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }

    @Override
    public int compareTo(Task o) {
        return this.start.compareTo(o.start);
    }

    @Override
    public String toString() {
        return start.format(TF) + " - " + end.format(TF) + ": " + description + " [" + priority + "]" + (completed ? " (Completed)" : "");
    }
}
