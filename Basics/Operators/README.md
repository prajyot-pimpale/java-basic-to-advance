# 📘 Operators in Java

## 1️⃣ What are Operators?

Operators are symbols used to perform operations on variables and values.

---

# 🔹 Types of Operators

1. Arithmetic Operators  
2. Relational Operators  
3. Logical Operators  
4. Assignment Operators  
5. Unary Operators  
6. Bitwise Operators  
7. Ternary Operator  
8. Shift Operators  

---

# 2️⃣ Arithmetic Operators

Used for mathematical calculations.

## Arithmetic Operators Table

| Operator | Meaning | Example |
|---|---|---|
| `+` | Addition | `10 + 3` |
| `-` | Subtraction | `10 - 3` |
| `*` | Multiplication | `10 * 3` |
| `/` | Division | `10 / 3` |
| `%` | Modulus | `10 % 3` |

---

# 3️⃣ Relational Operators

Used to compare values.

## Relational Operators Table

| Operator | Meaning |
|---|---|
| `>` | Greater Than |
| `<` | Less Than |
| `>=` | Greater Than or Equal |
| `<=` | Less Than or Equal |
| `==` | Equal To |
| `!=` | Not Equal To |

---

# 4️⃣ Logical Operators

Used to combine conditions.

## Logical Operators Table

| Operator | Meaning |
|---|---|
| `&&` | AND |
| `||` | OR |
| `!` | NOT |

---

# Truth Table

```text
+-------+-------+--------+--------+------+
|   A   |   B   | A&&B   | A||B   | !A   |
+-------+-------+--------+--------+------+
| true  | true  | true   | true   | false|
| true  | false | false  | true   | false|
| false | true  | false  | true   | true |
| false | false | false  | false  | true |
+-------+-------+--------+--------+------+
```

---

# 5️⃣ Assignment Operators

Used to assign values.

## Assignment Operators Table

| Operator | Example | Equivalent |
|---|---|---|
| `=` | `a = 10` | Assign |
| `+=` | `a += 5` | `a = a + 5` |
| `-=` | `a -= 3` | `a = a - 3` |
| `*=` | `a *= 2` | `a = a * 2` |
| `/=` | `a /= 4` | `a = a / 4` |
| `%=` | `a %= 2` | `a = a % 2` |

---

# 6️⃣ Unary Operators

Works on single operand.

## Unary Operators Table

| Operator | Meaning |
|---|---|
| `++` | Increment |
| `--` | Decrement |
| `+` | Unary Plus |
| `-` | Unary Minus |
| `!` | Logical NOT |

---

# Pre vs Post Increment

```text
a++ → use first, then increment
++a → increment first, then use
```

---

# 7️⃣ Ternary Operator

Short form of if-else.

## Syntax

```java
condition ? true_value : false_value
```

## Example

```java
int a = 10, b = 20;

int max = (a > b) ? a : b;

Output :- max = 20;
```

---

# 8️⃣ Bitwise Operators

Works on bits.

## Bitwise Operators Table

| Operator | Meaning |
|---|---|
| `&` | AND |
| `|` | OR |
| `^` | XOR |
| `~` | NOT |
| `<<` | Left Shift |
| `>>` | Right Shift |

---

# Bitwise Example

```text
a = 0101
b = 0011

a & b = 0001
a | b = 0111
a ^ b = 0110
```

---

# 9️⃣ Operator Precedence

```text
High Priority
--------------
++  --
*   /   %
+   -
>   <   >=   <=
==  !=
&&
||
?: 
=   +=   -=
--------------
Low Priority
```

## Example

```java
int result = 10 + 3 * 2;

System.out.println(result);
```

Output:

```text
16
```

---


# 🎯 Summary

| Operator Type | Symbols |
|---|---|
| Arithmetic | `+ - * / %` |
| Relational | `> < >= <= == !=` |
| Logical | `&& || !` |
| Assignment | `= += -= *= /= %=` |
| Unary | `++ -- + - !` |
| Ternary | `? :` |
| Bitwise | `& | ^ ~ << >>` |