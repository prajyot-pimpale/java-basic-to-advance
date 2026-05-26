import java.io.*;

public class CopyFile {
    public static void main(String[] args) {

        String source = "students.txt";
        String dest   = "students_copy.txt";

        try (
            BufferedReader br = new BufferedReader(new FileReader(source));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            System.out.println("File copied successfully");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}