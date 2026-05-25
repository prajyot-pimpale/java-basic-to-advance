# 📘 Topic 11 — Abstraction

---

## 1️⃣ What is Abstraction?

```text
Hiding implementation details and showing only essential features.

Real World:
  Car    → You press accelerator, don't know engine internals
  ATM    → You withdraw money, don't know bank system inside
  Mobile → You make a call, don't know signal processing

Show WHAT it does → Hide HOW it does it
```

### Two Ways to Achieve Abstraction

```text
1. Abstract Class  → partial abstraction (0% to 100%)
2. Interface       → full abstraction (100%)
```

---

## 2️⃣ Abstract Class

```text
Rules:
- Declared with abstract keyword
- Can have abstract methods (no body)
- Can have concrete methods (with body)
- Cannot create object of abstract class
- Child class MUST implement all abstract methods
```

```java
abstract class Animal {
    String name;

    // Abstract method → no body, must be overridden
    abstract void sound();

    // Concrete methods → have body
    void eat()   { System.out.println(name + " is eating"); }
    void sleep() { System.out.println(name + " is sleeping"); }
}
```

```java
class Dog extends Animal {
    Dog(String name) { this.name = name; }

    @Override
    void sound() { System.out.println(name + " barks"); }
}

class Cat extends Animal {
    Cat(String name) { this.name = name; }

    @Override
    void sound() { System.out.println(name + " meows"); }
}
```

```java
// Animal a = new Animal(); ← ERROR ❌ cannot instantiate

Dog d = new Dog("Tommy");
d.sound();  // Tommy barks
d.eat();    // Tommy is eating

Cat c = new Cat("Kitty");
c.sound();  // Kitty meows
c.sleep();  // Kitty is sleeping
```

---

## 3️⃣ Interface

```text
Rules:
- Declared with interface keyword
- All methods are public abstract by default
- All variables are public static final by default
- Implemented using implements keyword
- A class can implement MULTIPLE interfaces
- Cannot create object of interface
```

```java
interface Drawable {
    void draw();
    void resize();
}

interface Colorable {
    void fillColor(String color);
}
```

```java
// Single interface
class Circle implements Drawable {
    double radius;
    Circle(double r) { this.radius = r; }

    @Override public void draw()   { System.out.println("Drawing circle r=" + radius); }
    @Override public void resize() { System.out.println("Resizing circle"); }
}

// Multiple interfaces
class Square implements Drawable, Colorable {
    double side;
    Square(double s) { this.side = s; }

    @Override public void draw()              { System.out.println("Drawing square s=" + side); }
    @Override public void resize()            { System.out.println("Resizing square"); }
    @Override public void fillColor(String c) { System.out.println("Square color: " + c); }
}
```

```java
Circle ci = new Circle(5);
ci.draw();    // Drawing circle r=5.0
ci.resize();  // Resizing circle

Square sq = new Square(4);
sq.draw();             // Drawing square s=4.0
sq.fillColor("Red");   // Square color: Red
```

---

## 4️⃣ Abstract Class vs Interface

```text
┌─────────────────────┬──────────────────────┬────────────────────────┐
│                     │   Abstract Class     │      Interface         │
├─────────────────────┼──────────────────────┼────────────────────────┤
│ Keyword             │ abstract             │ interface              │
│ Methods             │ abstract + concrete  │ abstract by default    │
│ Variables           │ any type             │ public static final    │
│ Constructor         │ ✅ yes               │ ❌ no                  │
│ Multiple inherit    │ ❌ one class only    │ ✅ multiple allowed    │
│ Object creation     │ ❌ not allowed       │ ❌ not allowed         │
│ Use when            │ partial abstraction  │ full abstraction       │
└─────────────────────┴──────────────────────┴────────────────────────┘
```

---

## 5️⃣ Interface — `default` and `static` Methods (Java 8+)

```java
interface Vehicle {

    void start();  // abstract

    // Default method → has body, can be overridden
    default void fuelType() {
        System.out.println("Default fuel: Petrol");
    }

    // Static method → called using interface name
    static void info() {
        System.out.println("Vehicle Interface");
    }
}
```

```java
class Car extends implements Vehicle {
    @Override public void start() { System.out.println("Car started"); }

    @Override
    public void fuelType() { System.out.println("Car fuel: Diesel"); }
}

class Bike implements Vehicle {
    @Override public void start() { System.out.println("Bike started"); }
    // fuelType() not overridden → uses default
}
```

```java
Car  car  = new Car();
Bike bike = new Bike();

car.start();     // Car started
car.fuelType();  // Car fuel: Diesel     ← overridden

bike.start();    // Bike started
bike.fuelType(); // Default fuel: Petrol ← default used

Vehicle.info();  // Vehicle Interface    ← static call
```

---

## 6️⃣ Interface Extending Interface

```java
interface Shape {
    double area();
}

interface Shape3D extends Shape {
    double volume();
}

class Cube implements Shape3D {
    double side;
    Cube(double s) { this.side = s; }

    @Override public double area()   { return 6 * side * side; }
    @Override public double volume() { return side * side * side; }
}
```

```java
Cube cube = new Cube(3);
System.out.println("Area  : " + cube.area());    // 54.0
System.out.println("Volume: " + cube.volume());  // 27.0
```

---

## 7️⃣ Abstract Class with Constructor

```java
abstract class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    abstract void work();

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Engineer extends Person {
    String field;
    Engineer(String name, int age, String field) {
        super(name, age);
        this.field = field;
    }
    @Override
    void work() { System.out.println(name + " works as " + field + " Engineer"); }
}

class Doctor extends Person {
    String speciality;
    Doctor(String name, int age, String speciality) {
        super(name, age);
        this.speciality = speciality;
    }
    @Override
    void work() { System.out.println(name + " is a " + speciality + " Doctor"); }
}
```

```java
Engineer e = new Engineer("Alice", 28, "Software");
Doctor   d = new Doctor("Bob", 35, "Cardiologist");

e.display(); e.work();
// Name: Alice, Age: 28
// Alice works as Software Engineer

d.display(); d.work();
// Name: Bob, Age: 35
// Bob is a Cardiologist Doctor
```

---

## 8️⃣ Complete Example — Notification System

```java
interface Notification {
    void send(String message);
    void schedule(String time);

    default void log(String msg) {
        System.out.println("[LOG] Sent: " + msg);
    }
}

class EmailNotification implements Notification {
    String email;
    EmailNotification(String email) { this.email = email; }

    @Override public void send(String msg)     { System.out.println("Email to " + email + ": " + msg); log(msg); }
    @Override public void schedule(String time){ System.out.println("Email scheduled at: " + time); }
}

class SMSNotification implements Notification {
    String phone;
    SMSNotification(String phone) { this.phone = phone; }

    @Override public void send(String msg)     { System.out.println("SMS to " + phone + ": " + msg); log(msg); }
    @Override public void schedule(String time){ System.out.println("SMS scheduled at: " + time); }
}

class PushNotification implements Notification {
    String deviceId;
    PushNotification(String id) { this.deviceId = id; }

    @Override public void send(String msg)     { System.out.println("Push to " + deviceId + ": " + msg); log(msg); }
    @Override public void schedule(String time){ System.out.println("Push scheduled at: " + time); }
}
```

```java
Notification[] notifications = {
    new EmailNotification("alice@mail.com"),
    new SMSNotification("+91-9999999999"),
    new PushNotification("device-abc-123")
};

for (Notification n : notifications) {
    n.send("Your OTP is 1234");
    System.out.println("---");
}

// Email to alice@mail.com: Your OTP is 1234
// [LOG] Sent: Your OTP is 1234
// ---
// SMS to +91-9999999999: Your OTP is 1234
// [LOG] Sent: Your OTP is 1234
// ---
// Push to device-abc-123: Your OTP is 1234
// [LOG] Sent: Your OTP is 1234
```

---

## 9️⃣ When to Use What

```text
Use Abstract Class when:
  → Classes share common code or fields
  → You want partial implementation
  → You need a constructor
  → Close relationship between classes

Use Interface when:
  → Unrelated classes share same behavior
  → You need multiple inheritance
  → You want full abstraction
  → Defining a contract or capability
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Abstraction | Hide implementation, show only essentials |
| Abstract class | `abstract` keyword, mix of abstract + concrete |
| Abstract method | No body, must be overridden by child |
| Interface | All methods abstract by default, use `implements` |
| Multiple interface | A class can implement many interfaces |
| `default` method | Interface method with body (Java 8+) |
| `static` method | Called via interface name (Java 8+) |
| Abstract vs Interface | Abstract = partial, Interface = full abstraction |