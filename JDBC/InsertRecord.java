import java.sql.*;

public class InsertRecord {

    static final String URL  = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void main(String[] args) {

        String sql = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Insert student 1
            ps.setString(1, "Alice");
            ps.setInt(2, 20);
            ps.setDouble(3, 95.5);
            int rows = ps.executeUpdate();
            System.out.println("Inserted: " + rows + " row(s)");

            // Insert student 2
            ps.setString(1, "Bob");
            ps.setInt(2, 22);
            ps.setDouble(3, 88.0);
            ps.executeUpdate();

            // Insert student 3
            ps.setString(1, "Charlie");
            ps.setInt(2, 21);
            ps.setDouble(3, 76.5);
            ps.executeUpdate();

            System.out.println("All students inserted ✅");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}