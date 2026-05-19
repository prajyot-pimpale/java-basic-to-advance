# Java Basics ☕

## 📌 What is Java?
Java is a high-level, object-oriented, platform-independent programming language developed by Sun Microsystems.  
Java follows the principle:

> **Write Once, Run Anywhere (WORA)**

Java programs run on the JVM (Java Virtual Machine), which makes Java platform independent.

---

# ⚙️ How Java Works

```text
Source Code (.java)
        ↓
Compiler (javac)
        ↓
Bytecode (.class)
        ↓
JVM
        ↓
Output
```

---

# 🛠️ Java Components

| Component | Full Form | Purpose |
|-----------|------------|----------|
| JDK | Java Development Kit | Develop + Compile + Run |
| JRE | Java Runtime Environment | Run Java Programs |
| JVM | Java Virtual Machine | Executes Bytecode |

---

# 🚀 Setup

## Install
- JDK
- Eclips / VS Code / IntelliJ IDEA

## Verify Installation

```bash
java -version
javac -version
```

---

# 👋 First Java Program

```java
public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

---

# ▶️ Compile & Run

```bash
javac Hello.java
java Hello
```

---

# 🖨️ Print Statements

```java
System.out.println("Hello");
System.out.print("Java");
System.out.printf("Age: %d", 20);
```

---

# 💬 Comments in Java

```java
// Single-line comment

/*
 Multi-line comment
*/

/**
 * Javadoc comment
 */
```

---

# 📌 Java Rules

- File name must match class name
- Java is case-sensitive
- Every statement ends with `;`
- Execution starts from `main()`
- `{}` defines blocks

---

# 🎯 Summary

- Java is platform independent
- JVM executes Java bytecode
- `main()` is the entry point
- Java code is compiled using `javac`
- Java programs run using `java`
