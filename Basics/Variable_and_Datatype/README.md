# 📘 Variables & Data Types in Java

## 1️⃣ What is a Variable?

A variable is a named container used to store data in memory.

```java
int age = 25;
```

| Part | Meaning |
|---|---|
| `int` | Data Type |
| `age` | Variable Name |
| `25` | Value |

### Variable Steps

```java
// Declaration
int age;

// Initialization
age = 25;

// Both Together
int age = 25;
```

---

# 2️⃣ Java Data Types

```text
Data Types
│
├── Primitive Types
│     ├── byte
│     ├── short
│     ├── int
│     ├── long
│     ├── float
│     ├── double
│     ├── char
│     └── boolean
│
└── Non-Primitive Types
      ├── String
      ├── Arrays
      ├── Classes
      └── Interfaces
```

---

# 4️⃣ Data Type Cheat Sheet

| Type | Size | Example |
|---|---|---|
| `byte` | 1 byte | 127 |
| `short` | 2 bytes | 32000 |
| `int` | 4 bytes | 100 |
| `long` | 8 bytes | 999999L |
| `float` | 4 bytes | 5.5f |
| `double` | 8 bytes | 99.99 |
| `char` | 2 bytes | 'A' |
| `boolean` | 1 bit | true |

---

# 6️⃣ Type Casting

## ✅ Widening Casting

### Order

```text
byte → short → int → long → float → double
```

---

## ✅ Narrowing Casting

```java
double d = 9.99;
int i = (int) d;

```

---

## ✅ char ↔ int Casting

```java
char c = 'A';
int ascii = c;

int num = 66;
char ch = (char) num;


```

---

# 7️⃣ Constants using final

```text
We can not reassing value to variable that decleared with final.

Allowed: final int age = 25;
Error: age = 26;

```
### Naming Convention

```text
ALL_CAPS
```

---


# Scanner Methods

| Method | Reads |
|---|---|
| `nextInt()` | Integer |
| `nextDouble()` | Decimal |
| `nextFloat()` | Float |
| `nextLong()` | Long |
| `next()` | One Word |
| `nextLine()` | Full Line |
| `nextBoolean()` | Boolean |

---

# 9️⃣ Common Mistakes

## Integer Division

```java
int a = 5, b = 2;

System.out.println(a / b);
System.out.println(a / (double)b);
```

---

## Overflow

```java
int x = 2147483647;
x = x + 1;

System.out.println(x);
```

---

## nextInt() with nextLine()

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
sc.nextLine();

String name = sc.nextLine();
```

---

# 🎯 Summary

- Variables store data
- Java has 8 primitive types
- String is non-primitive
- Type casting converts one type to another
- `final` creates constants
- Scanner is used for user input