package Practice;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class StudentFilter {

    public static void main(String[] args) {

        List<String> students = Arrays.asList(
            "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank"
        );

        List<Integer> marks = Arrays.asList(95, 42, 88, 76, 55, 91);

        // Predicate — pass/fail
        Predicate<Integer> isPassing = mark -> mark >= 60;

        // Function — grade
        Function<Integer, String> getGrade = mark ->
            mark >= 90 ? "A" : mark >= 75 ? "B" : mark >= 60 ? "C" : "F";

        // Consumer — print result
        Consumer<String> printer = System.out::println;

        // Process
        System.out.println("=== Results ===");
        for (int i = 0; i < students.size(); i++) {
            String student = students.get(i);
            int    mark    = marks.get(i);
            String status  = isPassing.test(mark) ? "PASS" : "FAIL";
            String grade   = getGrade.apply(mark);

            printer.accept(String.format("%-10s %3d  %s  %s",
                                          student, mark, grade, status));
        }
    }
}

// Output:
// === Results ===
// Alice       95  A  PASS
// Bob         42  F  FAIL
// Charlie     88  B  PASS
// Diana       76  B  PASS
// Eve         55  F  FAIL
// Frank       91  A  PASS