import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {

        // Write to file (overwrites if exists)
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write("Hello, Java!\n");
            fw.write("This is file handling.\n");
            fw.write("Line 3\n");
            System.out.println("Written successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Append to file (add without overwriting)
        try (FileWriter fw = new FileWriter("output.txt", true)) {
            fw.write("This line is appended.\n");
            System.out.println("Appended successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}