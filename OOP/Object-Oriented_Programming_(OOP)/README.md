# 📘 Topic 8 — Object-Oriented Programming (OOP)

---

## 1️⃣ What is OOP?

```text
OOP organizes code around objects rather than functions.

Real World  →  Java
──────────────────────
Car         →  Class
My Car      →  Object
Color,Speed →  Fields
Drive,Brake →  Methods
```

### 4 Pillars of OOP

```text
1. Encapsulation  → hide data, expose via methods
2. Inheritance    → child class gets parent features
3. Polymorphism   → one name, many forms
4. Abstraction    → hide complexity, show essentials
```

---

## 2️⃣ Class & Object

```text
Class   → Blueprint / Template
        → Class is a way of implementing encapsulation.

Object  → Instance of class (real thing)
        → Object is somthing which has state(variables), behaviour(functions), identity(unique key) and responsibility.

Class  = House Plan
Object = Actual House built from that plan
```

```java
// Class
public class Car {
    String brand;
    String color;
    int speed;

    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }

    void brake() {
        System.out.println(brand + " stopped!");
    }
}
```

```java
// Create Objects
Car car1 = new Car();
car1.brand = "Toyota";
car1.color = "Red";
car1.speed = 120;
car1.drive();  // Toyota is driving at 120 km/h

Car car2 = new Car();
car2.brand = "Honda";
car2.speed = 100;
car2.drive();  // Honda is driving at 100 km/h
```

---

## 3️⃣ Constructor

Special method called automatically when object is created.

```text
Rules:
- Same name as class
- No return type (not even void)
- Called automatically with new keyword
```

```java
public class Student {

    String name;
    int    age;
    double marks;

    // Default Constructor
    Student() {
        name  = "Unknown";
        age   = 0;
        marks = 0.0;
    }

    // Parameterized Constructor
    Student(String name, int age, double marks) {
        this.name  = name;
        this.age   = age;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}
```

```java
Student s1 = new Student();                   // default
Student s2 = new Student("Alice", 20, 95.5);  // parameterized

s1.display();  // Name: Unknown, Age: 0, Marks: 0.0
s2.display();  // Name: Alice,   Age: 20, Marks: 95.5
```

---

## 4️⃣ `this` Keyword

Refers to the current invoking object.

```java
Person(String name, int age) {
    this.name = name;  // this.name = field, name = parameter
    this.age  = age;
}

// this() → call another constructor
Person(String name) {
    this(name, 0);     // calls Person(String, int)
}

// Return current object for method chaining
Person setName(String name) {
    this.name = name;
    return this;
}
```

---

## 5️⃣ Constructor Overloading

Multiple constructors with different parameters.

```java
public class Box {
    double length, width, height;

    Box()                              { length = width = height = 1; }
    Box(double side)                   { length = width = height = side; }
    Box(double l, double w, double h)  { length = l; width = w; height = h; }

    double volume() { return length * width * height; }
}
```

```java
Box b1 = new Box();         // 1x1x1  → volume = 1.0
Box b2 = new Box(5);        // 5x5x5  → volume = 125.0
Box b3 = new Box(2, 3, 4);  // 2x3x4  → volume = 24.0
```

---

## 6️⃣ `static` Keyword

`static` members belong to the class, not the object.

```java
public class Counter {
    static int count = 0;  // shared across all objects
    String name;

    Counter(String name) {
        this.name = name;
        count++;
    }

    static void showCount() {
        System.out.println("Total objects: " + count);
    }
}
```

```java
Counter c1 = new Counter("A");
Counter c2 = new Counter("B");
Counter c3 = new Counter("C");

Counter.showCount();  // Total objects: 3
```

```text
static variable → one copy shared by all objects
static method   → called using class name
static block    → runs once when class is loaded
```

---

## 7️⃣ Static Block & Instance Block

```java
public class Demo {

    static int x;
    int y;

    // Runs ONCE when class loads
    static {
        x = 100;
        System.out.println("Static block: x = " + x);
    }

    // Runs every time object is created
    {
        y = 200;
        System.out.println("Instance block: y = " + y);
    }

    Demo() {
        System.out.println("Constructor called");
    }
}
```

```text
Output for two objects:
Static block: x = 100      ← only once
Instance block: y = 200    ← for d1
Constructor called
Instance block: y = 200    ← for d2
Constructor called
```

---

## 8️⃣ Access Modifiers

Control who can access fields and methods.

```java
public    String ownerName;  // accessible everywhere
private   double balance;    // only inside this class
protected String bankName;   // this class + subclasses + same package
          int    pin;        // default → same package only
```

| Modifier | Same Class | Same Package | Subclass | Everywhere |
|---|---|---|---|---|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| default | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

---

## 9️⃣ Getters & Setters

Access and update private fields safely.

```java
public class Employee {

    private String name;
    private double salary;

    // Getters
    public String getName()   { return name; }
    public double getSalary() { return salary; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) {
        if (salary >= 0) this.salary = salary;
        else System.out.println("Salary cannot be negative");
    }
}
```

```java
Employee e = new Employee();
e.setName("Alice");
e.setSalary(50000);

System.out.println(e.getName());    // Alice
System.out.println(e.getSalary());  // 50000.0

e.setSalary(-100);  // Salary cannot be negative
```

---

## 🔟 Complete Example — Bank Account

```java
public class BankAccount {

    private String owner;
    private double balance;

    BankAccount(String owner, double balance) {
        this.owner   = owner;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    void withdraw(double amount) {
        if (amount > balance) System.out.println("Insufficient balance");
        else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void display() {
        System.out.println("Owner  : " + owner);
        System.out.println("Balance: " + balance);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", 1000);
        acc.display();
        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000);  // Insufficient balance
        acc.display();
    }
}
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Class | Blueprint / Template |
| Object | Instance of class, created with `new` |
| Constructor | Auto-called on creation, same name as class |
| `this` | Refers to current object |
| `static` | Belongs to class, not object |
| Access Modifiers | `public` `private` `protected` default |
| Getters / Setters | Access and update private fields safely |