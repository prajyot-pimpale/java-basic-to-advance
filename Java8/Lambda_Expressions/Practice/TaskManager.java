import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class TaskManager {

    record Task(String title, String priority, boolean done) {}

    public static void main(String[] args) {

        List<Task> tasks = Arrays.asList(
            new Task("Fix bug",         "HIGH",   false),
            new Task("Write tests",     "MEDIUM", false),
            new Task("Deploy app",      "HIGH",   true),
            new Task("Update docs",     "LOW",    false),
            new Task("Code review",     "MEDIUM", true),
            new Task("Security audit",  "HIGH",   false)
        );

        // Filter lambdas
        Predicate<Task> isHigh    = t -> t.priority().equals("HIGH");
        Predicate<Task> isPending = t -> !t.done();
        Predicate<Task> urgent    = isHigh.and(isPending);

        // Display lambda
        Consumer<Task> display = t ->
            System.out.printf("[%s] %-20s (%s)%n",
                t.done() ? "✓" : " ", t.title(), t.priority());

        // Show all pending high priority
        System.out.println("=== Urgent Tasks ===");
        tasks.stream()
             .filter(urgent)
             .forEach(display);

        // Count by priority
        System.out.println("\n=== Count by Priority ===");
        Map<String, Long> countByPriority = tasks.stream()
            .collect(Collectors.groupingBy(Task::priority, Collectors.counting()));
        countByPriority.forEach((p, c) ->
            System.out.println(p + ": " + c));

        // Completion rate
        long done  = tasks.stream().filter(Task::done).count();
        long total = tasks.size();
        System.out.printf("%n=== Progress: %d/%d (%.0f%%) ===%n",
                          done, total, (done * 100.0 / total));
    }
}

// Output:
// === Urgent Tasks ===
// [ ] Fix bug              (HIGH)
// [ ] Security audit       (HIGH)
// === Count by Priority ===
// HIGH: 3
// MEDIUM: 2
// LOW: 1
// === Progress: 2/6 (33%) ===