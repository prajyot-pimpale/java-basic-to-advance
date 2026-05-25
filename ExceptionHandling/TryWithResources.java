import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {

        // Resource auto-closed after try block
        try (FileReader fr = new FileReader("test.txt");
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        // No need to call fr.close() or br.close() manually
    }
}