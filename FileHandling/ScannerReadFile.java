import java.io.*;
import java.util.Scanner;

public class ScannerReadFile {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(new File("students.txt"))) {

            // Skip header
            if (sc.hasNextLine()) sc.nextLine();

            while (sc.hasNextLine()) {
                String line  = sc.nextLine();
                String[] parts = line.split(",");

                String name  = parts[0];
                int    age   = Integer.parseInt(parts[1]);
                double marks = Double.parseDouble(parts[2]);

                System.out.printf("Name: %-10s Age: %d  Marks: %.1f%n",
                                   name, age, marks);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}

// Output:
// Name: Alice      Age: 20  Marks: 95.0
// Name: Bob        Age: 22  Marks: 88.0
// Name: Charlie    Age: 21  Marks: 76.0