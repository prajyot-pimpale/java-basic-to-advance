import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {

        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Alice",   95);
        grades.put("Bob",     72);
        grades.put("Charlie", 88);
        grades.put("Diana",   60);

        // Print sorted by name using TreeMap
        TreeMap<String, Integer> sorted = new TreeMap<>(grades);

        for (var entry : sorted.entrySet()) {
            String grade =
                entry.getValue() >= 90 ? "A" :
                entry.getValue() >= 75 ? "B" :
                entry.getValue() >= 60 ? "C" : "F";

            System.out.println(entry.getKey() + " : " +
                               entry.getValue() + " → " + grade);
        }
        // Alice   : 95 → A
        // Bob     : 72 → C
        // Charlie : 88 → B
        // Diana   : 60 → C
    }
}