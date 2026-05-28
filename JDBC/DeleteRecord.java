import java.sql.*;

public class DeleteRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/school";
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DriverManager.getConnection(url, "root", "yourpassword");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 3);  // delete student with id=3

            int rows = ps.executeUpdate();
            System.out.println("Deleted: " + rows + " row(s)");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}