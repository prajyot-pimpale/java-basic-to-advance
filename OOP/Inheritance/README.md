# 📘 Topic 9 — Inheritance

---

## 1️⃣ What is Inheritance?

```text
Child class acquires properties and methods of a parent class.

Animal (parent)  →  eat(), sleep()
Dog    (child)   →  eat(), sleep() + bark()
Cat    (child)   →  eat(), sleep() + meow()

Benefits:
- Code reusability
- Less duplication
- Easy to maintain
- Represents real-world relationships
```

---

## 2️⃣ Syntax — `extends`

```java
class Parent {
    // fields and methods
}

class Child extends Parent {
    // inherits parent + adds own
}
```

---

## 3️⃣ Simple Inheritance

```java
// Parent
class Animal {
    String name;

    void eat()   { System.out.println(name + " is eating"); }
    void sleep() { System.out.println(name + " is sleeping"); }
}

// Children
class Dog extends Animal {
    void bark() { System.out.println(name + " is barking"); }
}

class Cat extends Animal {
    void meow() { System.out.println(name + " is meowing"); }
}
```

```java
Dog d = new Dog();
d.name = "Tommy";
d.eat();    // Tommy is eating   ← from Animal
d.sleep();  // Tommy is sleeping ← from Animal
d.bark();   // Tommy is barking  ← from Dog
```

---

## 4️⃣ Types of Inheritance

```text
1. Single       → One parent, one child
2. Multilevel   → A → B → C (chain)
3. Hierarchical → One parent, many children
4. Multiple     → NOT supported with classes (use interfaces)
5. Hybrid       → Combination (via interfaces)
```

---

## 5️⃣ Single Inheritance

```java
class Vehicle {
    int speed;
    void start() { System.out.println("Vehicle started"); }
    void stop()  { System.out.println("Vehicle stopped"); }
}

class Car extends Vehicle {
    String brand;
    void display() {
        System.out.println(brand + " speed: " + speed);
    }
}
```

```java
Car c = new Car();
c.brand = "Toyota";
c.speed = 120;
c.start();    // Vehicle started
c.display();  // Toyota speed: 120
c.stop();     // Vehicle stopped
```

---

## 6️⃣ Multilevel Inheritance

```java
class Animal {
    void eat()  { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}

class BabyDog extends Dog {
    void weep() { System.out.println("Baby dog weeps"); }
}
```

```java
BabyDog bd = new BabyDog();
bd.eat();   // from Animal   ← Level 1
bd.bark();  // from Dog      ← Level 2
bd.weep();  // from BabyDog  ← Level 3
```

---

## 7️⃣ Hierarchical Inheritance

```java
class Shape {
    void draw() { System.out.println("Drawing a shape"); }
}

class Circle extends Shape {
    void area(double r) {
        System.out.println("Circle area: " + (3.14 * r * r));
    }
}

class Rectangle extends Shape {
    void area(double l, double w) {
        System.out.println("Rectangle area: " + (l * w));
    }
}

class Triangle extends Shape {
    void area(double b, double h) {
        System.out.println("Triangle area: " + (0.5 * b * h));
    }
}
```

```java
Circle    c = new Circle();    c.draw(); c.area(5);      // area: 78.5
Rectangle r = new Rectangle(); r.draw(); r.area(4, 6);  // area: 24.0
Triangle  t = new Triangle();  t.draw(); t.area(3, 8);  // area: 12.0
```

---

## 8️⃣ `super` Keyword

Refers to the parent class.

```java
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }

    void eat() { System.out.println(name + " eats food"); }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name);         // call parent constructor → MUST be first line
        this.breed = breed;
    }

    void eat() {
        super.eat();         // call parent method
        System.out.println(name + " eats dog food");
    }
}
```

```java
Dog d = new Dog("Tommy", "Labrador");
d.eat();

// Output:
// Animal constructor: Tommy
// Tommy eats food         ← super.eat()
// Tommy eats dog food     ← Dog's own eat()
```

---

## 9️⃣ Method Overriding

Child class redefines a method from the parent class.

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
```

```java
Animal a = new Animal(); a.sound();  // Animal makes a sound
Dog    d = new Dog();    d.sound();  // Dog barks
Cat    c = new Cat();    c.sound();  // Cat meows
```

```text
Rules for Overriding:
- Same method name and parameters
- Same or wider return type
- Cannot override private / static / final methods
- Use @Override annotation (best practice)
```

---

## 🔟 Overriding vs Overloading

```text
┌─────────────┬────────────────────────┬───────────────────────┐
│             │      Overloading       │      Overriding       │
├─────────────┼────────────────────────┼───────────────────────┤
│ Where       │ Same class             │ Parent & Child class  │
│ Parameters  │ Must be different      │ Must be same          │
│ Return type │ Can be different       │ Must be same/wider    │
│ Keyword     │ No special keyword     │ @Override             │
│ Type        │ Compile time           │ Runtime               │
└─────────────┴────────────────────────┴───────────────────────┘
```

---

## 1️⃣1️⃣ `final` with Inheritance

```java
// final class → cannot be extended
final class Secure {
    void show() { System.out.println("Secure class"); }
}
// class Child extends Secure { }  ← ERROR ❌

// final method → cannot be overridden
class Parent {
    final void show() { System.out.println("Parent show"); }
}
class Child extends Parent {
    // void show() { }  ← ERROR ❌
}
```
---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Inheritance | Child gets parent fields and methods |
| `extends` | Keyword to inherit |
| Single | One parent → one child |
| Multilevel | A → B → C chain |
| Hierarchical | One parent → many children |
| `super` | Access parent constructor or method |
| Overriding | Child redefines parent method |
| `@Override` | Annotation for overriding (best practice) |
| `final` class | Cannot be extended |
| `final` method | Cannot be overridden |