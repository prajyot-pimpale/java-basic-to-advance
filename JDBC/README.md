# 📘 Topic 17 — JDBC (Java Database Connectivity)

---

## 1️⃣ What is JDBC?

```text
JDBC is an API that allows Java programs to connect and interact with databases.

Java App  →  JDBC API  →  JDBC Driver  →  Database

Real World Use:
  → Login system (check user in DB)
  → Student management (store/fetch records)
  → E-commerce (orders, products, users)
  → Banking (transactions, accounts)

Supported Databases:
  MySQL, PostgreSQL, Oracle, SQLite, SQL Server
```

---

## 2️⃣ JDBC Architecture

```text
Java Application
      ↓
  JDBC API  (java.sql.*)
      ↓
  JDBC Driver Manager
      ↓
  JDBC Driver (MySQL / Oracle / SQLite)
      ↓
  Database
```

---

## 3️⃣ JDBC Steps

```text
Step 1 → Load Driver
Step 2 → Create Connection
Step 3 → Create Statement
Step 4 → Execute Query
Step 5 → Process Result
Step 6 → Close Connection
```

---

## 4️⃣ Setup — MySQL

```sql
-- Create database and table
CREATE DATABASE school;
USE school;

CREATE TABLE students (
    id    INT PRIMARY KEY AUTO_INCREMENT,
    name  VARCHAR(50),
    age   INT,
    marks DOUBLE
);
```

```text
Add MySQL JDBC Driver:
  → Download: https://dev.mysql.com/downloads/connector/j/
  → Add mysql-connector-java.jar to classpath
```

---

## 5️⃣ Connect to Database

```java
import java.sql.*;

String url      = "jdbc:mysql://localhost:3306/school";
String username = "root";
String password = "yourpassword";

try {
    Class.forName("com.mysql.cj.jdbc.Driver"); // load driver

    Connection con = DriverManager.getConnection(url, username, password);
    System.out.println("Connected to database ✅");

    con.close();

} catch (ClassNotFoundException e) {
    System.out.println("Driver not found: " + e.getMessage());
} catch (SQLException e) {
    System.out.println("Connection failed: " + e.getMessage());
}
```

---

## 6️⃣ INSERT Record

```java
import java.sql.*;

String sql = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";

try (Connection con = DriverManager.getConnection(URL, USER, PASS);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setString(1, "Alice");
    ps.setInt(2, 20);
    ps.setDouble(3, 95.5);
    int rows = ps.executeUpdate();
    System.out.println("Inserted: " + rows + " row(s)");

    ps.setString(1, "Bob");
    ps.setInt(2, 22);
    ps.setDouble(3, 88.0);
    ps.executeUpdate();

    System.out.println("All students inserted ✅");

} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 7️⃣ SELECT Records

```java
import java.sql.*;

String sql = "SELECT * FROM students";

try (Connection con = DriverManager.getConnection(URL, USER, PASS);
     Statement  st  = con.createStatement();
     ResultSet  rs  = st.executeQuery(sql)) {

    System.out.printf("%-5s %-15s %-5s %-6s%n", "ID", "Name", "Age", "Marks");
    System.out.println("-".repeat(35));

    while (rs.next()) {
        int    id    = rs.getInt("id");
        String name  = rs.getString("name");
        int    age   = rs.getInt("age");
        double marks = rs.getDouble("marks");

        System.out.printf("%-5d %-15s %-5d %-6.1f%n", id, name, age, marks);
    }

} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}

// Output:
// ID    Name            Age   Marks
// -----------------------------------
// 1     Alice           20    95.5
// 2     Bob             22    88.0
```

---

## 8️⃣ UPDATE Record

```java
String sql = "UPDATE students SET marks = ? WHERE name = ?";

try (Connection con = DriverManager.getConnection(URL, USER, PASS);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setDouble(1, 99.0);
    ps.setString(2, "Alice");

    int rows = ps.executeUpdate();
    System.out.println("Updated: " + rows + " row(s)");

} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 9️⃣ DELETE Record

```java
String sql = "DELETE FROM students WHERE id = ?";

try (Connection con = DriverManager.getConnection(URL, USER, PASS);
     PreparedStatement ps = con.prepareStatement(sql)) {

    ps.setInt(1, 3);  // delete student with id = 3

    int rows = ps.executeUpdate();
    System.out.println("Deleted: " + rows + " row(s)");

} catch (SQLException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 🔟 Statement vs PreparedStatement

```text
┌────────────────────┬────────────────────┬──────────────────────┐
│                    │    Statement       │  PreparedStatement   │
├────────────────────┼────────────────────┼──────────────────────┤
│ SQL injection      │ ❌ vulnerable      │ ✅ safe              │
│ Performance        │ slower             │ faster (precompiled) │
│ Reusability        │ not reusable       │ reusable with params │
│ Use when           │ no user input      │ user input / params  │
└────────────────────┴────────────────────┴──────────────────────┘
```

```java
// Statement → SQL injection risk ❌
String name = "Alice' OR '1'='1";
String sql  = "SELECT * FROM students WHERE name = '" + name + "'";

// PreparedStatement → safe ✅
String sql = "SELECT * FROM students WHERE name = ?";
ps.setString(1, name);
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| JDBC | API to connect Java with database |
| Steps | Load → Connect → Statement → Execute → Process → Close |
| `Connection` | Created via `DriverManager.getConnection()` |
| `PreparedStatement` | Safe parameterized queries with `?` |
| `executeUpdate()` | For INSERT / UPDATE / DELETE |
| `executeQuery()` | For SELECT → returns `ResultSet` |
| `ResultSet` | Iterate with `rs.next()`, read with `rs.getString()` |
| try-with-resources | Auto-closes Connection and Statement |