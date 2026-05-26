import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {

        // Create File object (does NOT create actual file)
        File file = new File("test.txt");

        // Create actual file
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // File info
        System.out.println("Name     : " + file.getName());
        System.out.println("Path     : " + file.getAbsolutePath());
        System.out.println("Exists   : " + file.exists());
        System.out.println("Readable : " + file.canRead());
        System.out.println("Writable : " + file.canWrite());
        System.out.println("Size     : " + file.length() + " bytes");

        // Create directory
        File dir = new File("myFolder");
        if (dir.mkdir()) {
            System.out.println("Directory created");
        }

        // Delete file
        if (file.delete()) {
            System.out.println("File deleted");
        }
    }
}