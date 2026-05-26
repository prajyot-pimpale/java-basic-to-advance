import java.io.*;
import java.util.*;

public class StudentRecords {

    static final String FILE = "records.txt";

    // Write all students to file
    static void saveStudents(List<String[]> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (String[] s : students) {
                bw.write(String.join(",", s));
                bw.newLine();
            }
            System.out.println("Saved " + students.size() + " records");
        } catch (IOException e) {
            System.out.println("Save error: " + e.getMessage());
        }
    }

    // Read all students from file
    static List<String[]> loadStudents() {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
        return list;
    }

    // Display all students
    static void displayAll(List<String[]> students) {
        System.out.println("\n--- Student Records ---");
        System.out.printf("%-5s %-15s %-5s %-6s%n", "ID", "Name", "Age", "Marks");
        System.out.println("-".repeat(35));
        for (String[] s : students) {
            System.out.printf("%-5s %-15s %-5s %-6s%n",
                              s[0], s[1], s[2], s[3]);
        }
    }

    public static void main(String[] args) {

        // Create student records
        List<String[]> students = new ArrayList<>();
        students.add(new String[]{"101", "Alice",   "20", "95.5"});
        students.add(new String[]{"102", "Bob",     "22", "88.0"});
        students.add(new String[]{"103", "Charlie", "21", "76.5"});
        students.add(new String[]{"104", "Diana",   "23", "91.0"});

        // Save to file
        saveStudents(students);

        // Load from file and display
        List<String[]> loaded = loadStudents();
        displayAll(loaded);
    }
}

// Output:
// Saved 4 records
// --- Student Records ---
// ID    Name            Age   Marks
// -----------------------------------
// 101   Alice           20    95.5
// 102   Bob             22    88.0
// 103   Charlie         21    76.5
// 104   Diana           23    91.0