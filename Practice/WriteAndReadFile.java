import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WriteAndReadFile {
    public static void main(String[] args) {

        // Write
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.txt"))) {
            bw.write("Line 1\nLine 2\nLine 3\n");
        }

        // Read
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            br.lines().forEach(System.out::println);
        }
        
    }
}
