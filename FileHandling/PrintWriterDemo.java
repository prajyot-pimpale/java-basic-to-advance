import java.io.*;

public class PrintWriterDemo {
    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("report.txt"))) {

            pw.println("===== Student Report =====");
            pw.printf("%-15s %-5s %-6s%n", "Name", "Age", "Marks");
            pw.println("--------------------------");
            pw.printf("%-15s %-5d %-6.1f%n", "Alice",   20, 95.5);
            pw.printf("%-15s %-5d %-6.1f%n", "Bob",     22, 88.0);
            pw.printf("%-15s %-5d %-6.1f%n", "Charlie", 21, 76.5);
            pw.println("==========================");

            System.out.println("Report written");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}