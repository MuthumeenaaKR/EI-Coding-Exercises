
package com.eicoding.exercise2.scheduler;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ScheduleManager manager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        manager.addObserver(new ConflictNotifier());
        AppState state = AppState.RUNNING;
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Astronaut Daily Schedule Organizer ---");

        while (state != AppState.EXIT) {
            printMenu();
            String option = sc.nextLine().trim();
            try {
                switch (option) {
                    case "1":
                        handleAdd(sc);
                        break;
                    case "2":
                        handleRemove(sc);
                        break;
                    case "3":
                        handleView();
                        break;
                    case "4":
                        handleMarkCompleted(sc);
                        break;
                    case "0":
                        state = AppState.EXIT;
                        break;
                    default:
                        System.out.println("Invalid option. Choose from the menu.");
                }
            } catch (IllegalArgumentException ex) {
                ConsoleLogger.getLogger().error(ex.getMessage());
            } catch (Exception ex) {
                ConsoleLogger.getLogger().error("Unexpected error: " + ex.getMessage());
            }
        }

        System.out.println("Exiting scheduler. Goodbye.");
        sc.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1) Add Task");
        System.out.println("2) Remove Task");
        System.out.println("3) View Tasks (sorted by start time)");
        System.out.println("4) Mark Task Completed");
        System.out.println("0) Exit");
        System.out.print("Select: ");
    }

    private static void handleAdd(Scanner sc) {
        System.out.print("Description: ");
        String desc = sc.nextLine().trim();
        System.out.print("Start time (HH:mm): ");
        String start = sc.nextLine().trim();
        System.out.print("End time (HH:mm): ");
        String end = sc.nextLine().trim();
        System.out.print("Priority (High/Medium/Low): ");
        String priority = sc.nextLine().trim();
        Task t = TaskFactory.createTask(desc, start, end, priority);
        manager.addTask(t);
        System.out.println("Task added successfully. No conflicts.");
    }

    private static void handleRemove(Scanner sc) {
        System.out.print("Task description to remove: ");
        String desc = sc.nextLine().trim();
        manager.removeTask(desc);
        System.out.println("Task removed successfully.");
    }

    private static void handleView() {
        List<Task> list = manager.getTasksSorted();
        if (list.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            System.out.println("Scheduled tasks:");
            for (Task t : list) {
                System.out.println(t.toString());
            }
        }
    }

    private static void handleMarkCompleted(Scanner sc) {
        System.out.print("Task description to mark completed: ");
        String desc = sc.nextLine().trim();
        manager.markCompleted(desc);
        System.out.println("Task marked completed.");
    }
}
