import java.io.*;

public class BufferedReadDemo {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

            String line;
            int lineNo = 1;

            while ((line = br.readLine()) != null) {
                System.out.println(lineNo + ": " + line);
                lineNo++;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Output:
// 1: Name,Age,Marks
// 2: Alice,20,95
// 3: Bob,22,88
// 4: Charlie,21,76