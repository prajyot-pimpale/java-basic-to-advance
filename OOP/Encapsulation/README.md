# 📘 Topic 12 — Encapsulation

---

## 1️⃣ What is Encapsulation?

```text
Wrapping data (fields) and methods together
and restricting direct access to fields.

Real World:
  Capsule  → ingredients packed inside, can't be changed
  ATM      → internal logic hidden, only buttons exposed
  TV Remote → circuits hidden, buttons are the interface

Principle:
  Make fields  → PRIVATE
  Access them  → PUBLIC getters and setters
```

---

## 2️⃣ Why Encapsulation?

```text
Without Encapsulation:
  p.age    = -100;  ← invalid! No restriction
  p.salary = -999;  ← invalid! No restriction

With Encapsulation:
  p.setAge(-100);     → "Age cannot be negative" ← controlled!
  p.setSalary(-999);  → "Salary invalid"          ← validated!

Benefits:
  → Data protection from invalid input
  → Control over data access
  → Easy to change internal code without affecting outside
  → Increased security
```

---

## 3️⃣ Simple Encapsulation Example

```java
public class Person {

    // Private fields → hidden from outside
    private String name;
    private int    age;
    private double salary;

    // Getters
    public String getName()   { return name; }
    public int    getAge()    { return age; }
    public double getSalary() { return salary; }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) this.name = name;
        else System.out.println("Name cannot be empty");
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) this.age = age;
        else System.out.println("Invalid age: " + age);
    }

    public void setSalary(double salary) {
        if (salary >= 0) this.salary = salary;
        else System.out.println("Salary cannot be negative");
    }
}
```

```java
Person p = new Person();
p.setName("Alice");
p.setAge(25);
p.setSalary(50000);

System.out.println(p.getName());    // Alice
System.out.println(p.getAge());     // 25
System.out.println(p.getSalary());  // 50000.0

p.setAge(-5);       // Invalid age: -5
p.setSalary(-1000); // Salary cannot be negative
p.setName("");      // Name cannot be empty
```

---

## 4️⃣ Encapsulation with Constructor

```java
public class Student {

    private String name;
    private int    rollNo;
    private double marks;

    public Student(String name, int rollNo, double marks) {
        setName(name);
        setRollNo(rollNo);
        setMarks(marks);
    }

    // Getters
    public String getName()   { return name; }
    public int    getRollNo() { return rollNo; }
    public double getMarks()  { return marks; }

    // Setters with validation
    public void setName(String name)     { this.name   = (name != null && !name.isEmpty()) ? name : "Unknown"; }
    public void setRollNo(int rollNo)    { this.rollNo = (rollNo > 0) ? rollNo : 0; }
    public void setMarks(double marks)   { this.marks  = (marks >= 0 && marks <= 100) ? marks : 0; }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public void display() {
        System.out.println("Roll: " + rollNo + " | Name: " + name +
                           " | Marks: " + marks + " | Grade: " + getGrade());
    }
}
```

```java
Student s1 = new Student("Alice", 101, 92.5);
Student s2 = new Student("Bob",   102, 73.0);
Student s3 = new Student("", -1, 150);   // invalid → defaults

s1.display();  // Roll: 101 | Name: Alice   | Marks: 92.5 | Grade: A
s2.display();  // Roll: 102 | Name: Bob     | Marks: 73.0 | Grade: C
s3.display();  // Roll: 0   | Name: Unknown | Marks: 0.0  | Grade: F
```

---

## 5️⃣ Read-Only & Write-Only Fields

```java
public class Config {

    // Read-Only → only getter, no setter
    private final String appName = "MyApp";
    private final String version = "1.0.0";

    public String getAppName() { return appName; }
    public String getVersion()  { return version; }
    // no setters → cannot be changed

    // Write-Only → only setter, no getter (e.g. password)
    private String password;

    public void setPassword(String password) {
        if (password.length() >= 8) this.password = password;
        else System.out.println("Password too short (min 8 chars)");
    }
    // no getter → password cannot be read directly
}
```

```java
Config c = new Config();
System.out.println(c.getAppName());  // MyApp
System.out.println(c.getVersion());  // 1.0.0

c.setPassword("mypass123");  // ok
c.setPassword("abc");        // Password too short
```

---

## 6️⃣ Access Modifiers in Encapsulation

```text
Best Practice:
  Fields    → always private
  Getters   → public
  Setters   → public (with validation)

private   → field hidden from all outside classes
public    → getters/setters open to everyone
protected → accessible in subclasses
```
---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Encapsulation | Wrap data + methods, restrict direct access |
| `private` fields | Hidden from outside classes |
| Getter | Public method to read private field |
| Setter | Public method to write with validation |
| Read-only | Only getter, no setter |
| Write-only | Only setter, no getter (e.g. password) |
| Benefit | Data protection, validation, security |