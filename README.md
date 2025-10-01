
# Exercise 2 — Astronaut Daily Schedule Organizer (Java)

Console application that manages astronaut tasks for a day.

Key design elements:
- **Singleton**: ScheduleManager is a singleton.
- **Factory**: TaskFactory creates Task objects from strings (validates format).
- **Observer**: ConflictNotifier subscribes to schedule manager and is notified when conflicts occur.
- **SOLID & OOP**: Clear single-responsibility classes, interfaces for observers, and defensive checks.
- Logging and graceful exception handling are included.

To compile and run:

```bash
# from this folder
find src -name "*.java" > sources.txt
javac -d bin @sources.txt
java -cp bin com.eicoding.exercise2.scheduler.Main
```

Sample operations (menu will appear): Add task, Remove task, View tasks (sorted), Exit.
