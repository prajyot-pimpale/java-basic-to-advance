import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL  = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    // CREATE
    static void insert(String name, int age, double marks) {
        String sql = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            ps.executeUpdate();
            System.out.println("Student added: " + name);
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // READ ALL
    static void selectAll() {
        String sql = "SELECT * FROM students ORDER BY id";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st  = con.createStatement();
             ResultSet rs  = st.executeQuery(sql)) {

            System.out.printf("%n%-5s %-15s %-5s %-6s%n", "ID", "Name", "Age", "Marks");
            System.out.println("-".repeat(35));
            while (rs.next()) {
                System.out.printf("%-5d %-15s %-5d %-6.1f%n",
                    rs.getInt("id"), rs.getString("name"),
                    rs.getInt("age"), rs.getDouble("marks"));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // UPDATE
    static void update(int id, double newMarks) {
        String sql = "UPDATE students SET marks = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, newMarks);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated successfully" : "ID not found");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    // DELETE
    static void delete(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted successfully" : "ID not found");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public static void main(String[] args) {

        // Create
        insert("Alice",   20, 95.5);
        insert("Bob",     22, 88.0);
        insert("Charlie", 21, 76.5);
        insert("Diana",   23, 91.0);

        // Read
        selectAll();

        // Update
        update(1, 99.0);
        selectAll();

        // Delete
        delete(3);
        selectAll();
    }
}