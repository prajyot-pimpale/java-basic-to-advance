import java.io.BufferedReader;
import java.io.FileReader;

public class CountLinesInFile {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            long count = br.lines().count();
            System.out.println("Lines: " + count);
        }
    
    }
}
