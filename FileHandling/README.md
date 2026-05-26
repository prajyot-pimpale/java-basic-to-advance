# 📘 Topic 15 — File Handling

---

## 1️⃣ What is File Handling?

```text
File Handling allows Java to create, read, write, update and delete files.

Real World Use:
  → Save user data to a file
  → Read config files
  → Write logs
  → Export reports

Key Classes:
  File          → represents file/directory path
  FileWriter    → write text to file
  FileReader    → read text from file
  BufferedWriter → write with buffer (faster)
  BufferedReader → read with buffer (faster)
  PrintWriter   → formatted write to file
  Scanner       → read file using Scanner
```

---

## 2️⃣ File Class — Create, Check, Delete

```java
import java.io.File;
import java.io.IOException;

File file = new File("test.txt");

// Create actual file
try {
    if (file.createNewFile()) System.out.println("File created");
    else System.out.println("File already exists");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}

// File info
System.out.println("Name    : " + file.getName());
System.out.println("Path    : " + file.getAbsolutePath());
System.out.println("Exists  : " + file.exists());
System.out.println("Size    : " + file.length() + " bytes");

// Create directory
File dir = new File("myFolder");
if (dir.mkdir()) System.out.println("Directory created");

// Delete file
if (file.delete()) System.out.println("File deleted");
```

---

## 3️⃣ Write to File — FileWriter

```java
import java.io.FileWriter;
import java.io.IOException;

// Overwrite mode
try (FileWriter fw = new FileWriter("output.txt")) {
    fw.write("Hello, Java!\n");
    fw.write("This is file handling.\n");
    fw.write("Line 3\n");
    System.out.println("Written successfully");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}

// Append mode
try (FileWriter fw = new FileWriter("output.txt", true)) {
    fw.write("This line is appended.\n");
    System.out.println("Appended successfully");
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

```text
FileWriter("file.txt")       → overwrite mode
FileWriter("file.txt", true) → append mode
```

---

## 4️⃣ Read from File — FileReader

```java
import java.io.FileReader;
import java.io.IOException;

try (FileReader fr = new FileReader("output.txt")) {
    int ch;
    while ((ch = fr.read()) != -1) {
        System.out.print((char) ch);  // one char at a time
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

```text
fr.read() → returns int (character code)
-1        → end of file
(char) ch → convert int to character
```

---

## 5️⃣ BufferedWriter — Faster Writing

```java
import java.io.*;

try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {

    bw.write("Name,Age,Marks");
    bw.newLine();                 // platform-independent newline
    bw.write("Alice,20,95");
    bw.newLine();
    bw.write("Bob,22,88");
    bw.newLine();
    bw.write("Charlie,21,76");
    bw.newLine();

    System.out.println("Written successfully");

} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 6️⃣ BufferedReader — Faster Reading

```java
import java.io.*;

try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {

    String line;
    int lineNo = 1;

    while ((line = br.readLine()) != null) {
        System.out.println(lineNo + ": " + line);
        lineNo++;
    }

} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}

// Output:
// 1: Name,Age,Marks
// 2: Alice,20,95
// 3: Bob,22,88
// 4: Charlie,21,76
```

---

## 7️⃣ PrintWriter — Formatted Writing

```java
import java.io.*;

try (PrintWriter pw = new PrintWriter(new FileWriter("report.txt"))) {

    pw.println("===== Student Report =====");
    pw.printf("%-15s %-5s %-6s%n", "Name", "Age", "Marks");
    pw.println("--------------------------");
    pw.printf("%-15s %-5d %-6.1f%n", "Alice",   20, 95.5);
    pw.printf("%-15s %-5d %-6.1f%n", "Bob",     22, 88.0);
    pw.printf("%-15s %-5d %-6.1f%n", "Charlie", 21, 76.5);
    pw.println("==========================");

} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 8️⃣ Read File using Scanner

```java
import java.io.*;
import java.util.Scanner;

try (Scanner sc = new Scanner(new File("students.txt"))) {

    if (sc.hasNextLine()) sc.nextLine();  // skip header

    while (sc.hasNextLine()) {
        String   line  = sc.nextLine();
        String[] parts = line.split(",");

        String name  = parts[0];
        int    age   = Integer.parseInt(parts[1]);
        double marks = Double.parseDouble(parts[2]);

        System.out.printf("Name: %-10s Age: %d  Marks: %.1f%n",
                           name, age, marks);
    }

} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
}

// Output:
// Name: Alice      Age: 20  Marks: 95.0
// Name: Bob        Age: 22  Marks: 88.0
// Name: Charlie    Age: 21  Marks: 76.0
```

---

## 9️⃣ Copy File

```java
import java.io.*;

try (
    BufferedReader br = new BufferedReader(new FileReader("students.txt"));
    BufferedWriter bw = new BufferedWriter(new FileWriter("students_copy.txt"))
) {
    String line;
    while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
    }
    System.out.println("File copied successfully");

} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 1️⃣1️⃣ File Classes Cheat Sheet

| Class | Use |
|---|---|
| `File` | Create, delete, check file/directory |
| `FileWriter` | Write text to file |
| `FileReader` | Read text char by char |
| `BufferedWriter` | Faster writing with buffer |
| `BufferedReader` | Faster reading, line by line |
| `PrintWriter` | Formatted write (printf style) |
| `Scanner` | Convenient file reading |

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| `File` | Represents path, create/delete/check |
| `FileWriter` | Write — overwrite or append mode |
| `FileReader` | Read character by character |
| `BufferedWriter` | Faster write, use `newLine()` |
| `BufferedReader` | Faster read, use `readLine()` |
| `PrintWriter` | Formatted output to file |
| `Scanner` | Convenient file reading |
| try-with-resources | Auto-closes file, no manual close needed |