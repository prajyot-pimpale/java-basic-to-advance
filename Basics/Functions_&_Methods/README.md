# 📘 Topic 7 — Functions & Methods

---

## 1️⃣ What is a Method?

```text
A method is a block of code that performs a specific task.
Write once → call anywhere.

Benefits:
- Code reusability
- Easy to read and debug
- Divide big problem into small parts
```

---

## 2️⃣ Method Structure

```java
accessModifier returnType methodName(parameters) {
    // body
    return value;
}
```

```text
public   static   int   add  (int a, int b)
   ↑        ↑      ↑     ↑        ↑
access  modifier return name  parameters
```

---

## 3️⃣ Types of Methods

```text
1. No parameter, No return
2. With parameter, No return
3. No parameter, With return
4. With parameter, With return
```

```java
// 1. No parameter, No return
static void greet() {
    System.out.println("Hello!");
}

// 2. With parameter, No return
static void printName(String name) {
    System.out.println("Name: " + name);
}

// 3. No parameter, With return
static int getNumber() {
    return 42;
}

// 4. With parameter, With return
static int add(int a, int b) {
    return a + b;
}
```

---

## 4️⃣ return Statement

```java
// Single return
static int square(int n) {
    return n * n;
}

// Multiple returns
static String checkAge(int age) {
    if (age >= 18) return "Adult";
    else           return "Minor";
}

// void — no return needed
static void printSquare(int n) {
    System.out.println(n * n);
}
```

---

## 5️⃣ Method Parameters

```java
// Single parameter
static void printDouble(int n) {
    System.out.println(n * 2);
}

// Multiple parameters
static int add(int a, int b) {
    return a + b;
}

// String parameters
static String fullName(String first, String last) {
    return first + " " + last;
}

// Array as parameter
static void printArray(int[] arr) {
    for (int n : arr)
        System.out.print(n + " ");
}
```

---

## 6️⃣ Method Overloading

Same method name, different parameters.

```java
static int    add(int a, int b)          { return a + b; }
static int    add(int a, int b, int c)   { return a + b + c; }
static double add(double a, double b)    { return a + b; }
static String add(String a, String b)    { return a + b; }
```

```java
System.out.println(add(2, 3));              // 5
System.out.println(add(2, 3, 4));           // 9
System.out.println(add(2.5, 3.5));          // 6.0
System.out.println(add("Hello", " World")); // Hello World
```

```text
Must differ in:
  → Number of parameters     add(a,b) vs add(a,b,c)
  → Type of parameters       add(int,int) vs add(double,double)
  → Order of parameters      add(int,String) vs add(String,int)

Return type alone is NOT enough to overload.
```

---

## 7️⃣ Recursion

A method that calls itself.

```java
// Factorial
static long factorial(int n) {
    if (n == 0 || n == 1) return 1;   // base case
    return n * factorial(n - 1);      // recursive call
}
// factorial(5) = 5 * 4 * 3 * 2 * 1 = 120

// Fibonacci
static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Power
static long power(int base, int exp) {
    if (exp == 0) return 1;
    return base * power(base, exp - 1);
}
```

```text
Every recursion needs:
  1. Base case     → stops the recursion
  2. Recursive call → calls itself with smaller input
```

---

## 8️⃣ Pass by Value

```java
// Primitive — copy is passed (original unchanged)
int x = 10;
change(x);
System.out.println(x);  // still 10

static void change(int n) { n = 99; }  // only local copy changes

// Array — reference copy (original CAN change)
int[] arr = {1, 2, 3};
changeArray(arr);
System.out.println(arr[0]);  // 99 ← changed!

static void changeArray(int[] arr) { arr[0] = 99; }
```

---

## 9️⃣ Variable Scope

```java
static int globalVar = 100;  // class level

public static void main(String[] args) {
    int localVar = 10;       // only inside main

    System.out.println(globalVar);  // 100 ✅
    System.out.println(localVar);   // 10  ✅
}

static void show() {
    System.out.println(globalVar);  // 100 ✅
    // System.out.println(localVar); ← ERROR ❌
}
```

```text
Scope Rules:
  Local variable  → only inside the method/block declared
  Class variable  → accessible in all methods
  Block variable  → only inside { } block
```

---

## 🔟 Varargs — Variable Arguments

Accept any number of arguments.

```java
static int sum(int... nums) {
    int total = 0;
    for (int n : nums) total += n;
    return total;
}

System.out.println(sum(1, 2));           // 3
System.out.println(sum(1, 2, 3));        // 6
System.out.println(sum(1, 2, 3, 4, 5)); // 15
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Method | Block of code, write once call many times |
| return | Sends value back to caller |
| Parameters | Input values passed to method |
| Overloading | Same name, different parameters |
| Recursion | Method calls itself, needs base case |
| Pass by value | Primitive copy passed, not original |
| Varargs | `int... nums` accepts any number of args |
| Scope | Local inside method, class-level everywhere |