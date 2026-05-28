import java.sql.*;

public class SelectRecords {

    static final String URL  = "jdbc:mysql://localhost:3306/school";
    static final String USER = "root";
    static final String PASS = "yourpassword";

    public static void main(String[] args) {

        String sql = "SELECT * FROM students";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st  = con.createStatement();
             ResultSet rs  = st.executeQuery(sql)) {

            System.out.printf("%-5s %-15s %-5s %-6s%n", "ID", "Name", "Age", "Marks");
            System.out.println("-".repeat(35));

            while (rs.next()) {
                int    id    = rs.getInt("id");
                String name  = rs.getString("name");
                int    age   = rs.getInt("age");
                double marks = rs.getDouble("marks");

                System.out.printf("%-5d %-15s %-5d %-6.1f%n",
                                   id, name, age, marks);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Output:
// ID    Name            Age   Marks
// -----------------------------------
// 1     Alice           20    95.5
// 2     Bob             22    88.0
// 3     Charlie         21    76.5