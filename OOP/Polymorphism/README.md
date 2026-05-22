# 📘 Topic 10 — Polymorphism

---

## 1️⃣ What is Polymorphism?

```text
poly  = many
morph = forms

Same method name → different behavior based on object or input.

Real World:
  Person acts as → Employee at office
  Person acts as → Father at home
  Person acts as → Customer at shop
  Same person, different behavior.
```

### Two Types

```text
1. Compile-time Polymorphism → Method Overloading
2. Runtime Polymorphism      → Method Overriding
```

---

## 2️⃣ Compile-time Polymorphism

Resolved at compile time — via Method Overloading.

```java
public class Calculator {

    int    add(int a, int b)          { return a + b; }
    int    add(int a, int b, int c)   { return a + b + c; }
    double add(double a, double b)    { return a + b; }
    String add(String a, String b)    { return a + b; }
}
```

```java
Calculator calc = new Calculator();

System.out.println(calc.add(2, 3));             // 5
System.out.println(calc.add(2, 3, 4));          // 9
System.out.println(calc.add(2.5, 3.5));         // 6.0
System.out.println(calc.add("Hello", " Java")); // Hello Java
```

```text
Compiler decides WHICH method to call
based on number/type of arguments → Compile time
```

---

## 3️⃣ Runtime Polymorphism

Resolved at runtime — via Method Overriding + Upcasting.

```java
class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}

class Cow extends Animal {
    @Override
    void sound() { System.out.println("Cow moos"); }
}
```

```java
// Upcasting → parent reference, child object
Animal a1 = new Dog();
Animal a2 = new Cat();
Animal a3 = new Cow();

a1.sound();  // Dog barks  ← decided at RUNTIME
a2.sound();  // Cat meows
a3.sound();  // Cow moos
```

```text
JVM decides WHICH method to call
based on actual object type at runtime → Runtime Polymorphism
```

---

## 4️⃣ Upcasting & Downcasting

```java
// Upcasting → automatic (child → parent reference)
Animal a = new Dog();   // ✅ automatic
a.eat();                // ✅ works
// a.bark();            // ❌ Animal ref can't see Dog method

// Downcasting → manual (parent ref → child ref)
Dog d = (Dog) a;        // ✅ manual cast
d.eat();                // ✅ works
d.bark();               // ✅ works now

// Safe downcasting using instanceof
if (a instanceof Dog) {
    Dog dog = (Dog) a;
    dog.bark();
}
```

---

## 5️⃣ `instanceof` Operator

Check if an object is an instance of a class.

```java
Animal a = new Dog();

System.out.println(a instanceof Animal);  // true
System.out.println(a instanceof Dog);     // true
System.out.println(a instanceof Cat);     // false
```

```java
// Practical use — safe downcasting
Animal[] animals = {new Dog(), new Cat(), new Cow()};

for (Animal animal : animals) {
    if (animal instanceof Dog) ((Dog) animal).bark();
    else if (animal instanceof Cat) ((Cat) animal).meow();
}
```

---

## 6️⃣ Polymorphism with Array

```java
class Shape {
    void draw()      { System.out.println("Drawing shape"); }
    double area()    { return 0; }
}

class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    void draw()      { System.out.println("Drawing Circle"); }
    double area()    { return 3.14 * r * r; }
}

class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    void draw()   { System.out.println("Drawing Rectangle"); }
    double area() { return l * w; }
}

class Triangle extends Shape {
    double b, h;
    Triangle(double b, double h) { this.b = b; this.h = h; }
    void draw()   { System.out.println("Drawing Triangle"); }
    double area() { return 0.5 * b * h; }
}
```

```java
Shape[] shapes = {
    new Circle(5),
    new Rectangle(4, 6),
    new Triangle(3, 8)
};

for (Shape s : shapes) {
    s.draw();
    System.out.println("Area: " + s.area());
}

// Output:
// Drawing Circle     → Area: 78.5
// Drawing Rectangle  → Area: 24.0
// Drawing Triangle   → Area: 12.0
```

---

## 7️⃣ Polymorphism with Method Parameter

```java
class Printer {
    // One method accepts any Animal type
    void printSound(Animal a) {
        a.sound();  // calls overridden method of actual object
    }
}
```

```java
Printer p = new Printer();
p.printSound(new Dog());  // Dog barks
p.printSound(new Cat());  // Cat meows
p.printSound(new Cow());  // Cow moos
```

---

## 8️⃣ Compile-time vs Runtime

```text
┌──────────────────┬──────────────────────┬──────────────────────┐
│                  │  Compile-time        │  Runtime             │
├──────────────────┼──────────────────────┼──────────────────────┤
│ Also called      │ Static Polymorphism  │ Dynamic Polymorphism │
│ Achieved via     │ Method Overloading   │ Method Overriding    │
│ Resolved at      │ Compile time         │ Runtime (JVM)        │
│ Class needed     │ Same class           │ Parent + Child class │
│ Parameters       │ Must be different    │ Must be same         │
│ Performance      │ Faster               │ Slightly slower      │
└──────────────────┴──────────────────────┴──────────────────────┘
```

---


## 🎯 Summary

| Concept | Key Point |
|---|---|
| Polymorphism | One name, many forms |
| Compile-time | Method Overloading, resolved at compile time |
| Runtime | Method Overriding, resolved at runtime |
| Upcasting | Child object → Parent reference (automatic) |
| Downcasting | Parent reference → Child reference (manual) |
| `instanceof` | Check actual type of object |
| Polymorphic array | Parent array holds different child objects |