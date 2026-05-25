import java.io.*;

public class ThrowsDemo {

    // Declaring checked exception with throws
    static void readFile(String path) throws FileNotFoundException {
        FileReader fr = new FileReader(path);  // may throw
        System.out.println("File opened");
    }

    static int divide(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {

        // Must handle because of throws declaration
        try {
            readFile("test.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        try {
            System.out.println(divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}