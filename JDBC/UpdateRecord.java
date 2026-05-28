import java.sql.*;

public class UpdateRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";
        String sql = "UPDATE students SET marks = ? WHERE name = ?";

        try (Connection con = DriverManager.getConnection(url, "root", "yourpassword");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, 99.0);
            ps.setString(2, "Alice");

            int rows = ps.executeUpdate();
            System.out.println("Updated: " + rows + " row(s)");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}