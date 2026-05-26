import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("output.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);  // reads one char at a time
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
/*
    fr.read() → returns int (character code)
    -1        → end of file
    (char) ch → convert int to character
*/