import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {

        String url      = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "yourpassword";

        try {
            // Step 1: Load driver (optional in modern JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database ✅");

            // Step 6: Close
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}