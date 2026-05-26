import java.io.*;

public class BufferedWriteDemo {
    public static void main(String[] args) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {

            bw.write("Name,Age,Marks");
            bw.newLine();                    // platform-independent newline
            bw.write("Alice,20,95");
            bw.newLine();
            bw.write("Bob,22,88");
            bw.newLine();
            bw.write("Charlie,21,76");
            bw.newLine();

            System.out.println("File written successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}