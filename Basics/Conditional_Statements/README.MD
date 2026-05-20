# 📘 Topic 4 — Conditional Statements

---

## 1️⃣ What are Conditional Statements?

```text
Let your program make decisions based on conditions.

If marks >= 50  → Print "Pass"
Otherwise       → Print "Fail"
```

### Types

```text
1. if
2. if-else
3. if-else if ladder
4. Nested if
5. switch statement
6. switch expression (Java 14+)
```

---

## 2️⃣ `if` Statement

Executes block only if condition is true.

```java
int age = 20;

if (age >= 18) {
    System.out.println("You are eligible to vote");
}
```

---

## 3️⃣ `if-else` Statement

```java
int age = 15;

if (age >= 18) {
    System.out.println("Eligible to vote");
} else {
    System.out.println("Not eligible to vote");
}

// Even or Odd
int num = 7;
if (num % 2 == 0) {
    System.out.println(num + " is Even");
} else {
    System.out.println(num + " is Odd");
}
```

---

## 4️⃣ `if-else if` Ladder

Check multiple conditions one by one.

```java
int marks = 72;

if (marks >= 90) {
    System.out.println("Grade: A");
} else if (marks >= 75) {
    System.out.println("Grade: B");
} else if (marks >= 60) {
    System.out.println("Grade: C");
} else if (marks >= 50) {
    System.out.println("Grade: D");
} else {
    System.out.println("Grade: F");
}

// Output: Grade: C
```

```text
Flow:
marks >= 90 ? No
marks >= 75 ? No
marks >= 60 ? Yes → print Grade: C → stop
```

---

## 5️⃣ Nested `if`

`if` inside another `if`.

```java
int age = 20;
boolean hasID = true;

if (age >= 18) {
    if (hasID) {
        System.out.println("Entry allowed");
    } else {
        System.out.println("No ID, entry denied");
    }
} else {
    System.out.println("Underage, entry denied");
}
```

---

## 6️⃣ `switch` Statement

Used when one variable has many possible fixed values.

```java
int day = 3;

switch (day) {
    case 1:  System.out.println("Monday");    break;
    case 2:  System.out.println("Tuesday");   break;
    case 3:  System.out.println("Wednesday"); break;
    case 4:  System.out.println("Thursday");  break;
    case 5:  System.out.println("Friday");    break;
    case 6:  System.out.println("Saturday");  break;
    case 7:  System.out.println("Sunday");    break;
    default: System.out.println("Invalid day");
}

// Output: Wednesday
```

---

## 7️⃣ `break` vs Fall-Through

```java
int num = 2;

// WITHOUT break → fall-through
switch (num) {
    case 2: System.out.println("Two");     // runs
    case 3: System.out.println("Three");   // also runs!
    default:System.out.println("Default"); // also runs!
}
// Output: Two, Three, Default ❌

// WITH break → stops at matched case
switch (num) {
    case 2: System.out.println("Two"); break;  // runs then stops ✅
    case 3: System.out.println("Three"); break;
}
// Output: Two ✅
```

---

## 8️⃣ Multiple Cases — Same Block

```java
int month = 4;

switch (month) {
    case 1: case 3: case 5:
    case 7: case 8: case 10: case 12:
        System.out.println("31 days"); break;
    case 4: case 6: case 9: case 11:
        System.out.println("30 days"); break;
    case 2:
        System.out.println("28 or 29 days"); break;
    default:
        System.out.println("Invalid month");
}
// Output: 30 days
```

---

## 9️⃣ Switch Expression (Java 14+)

Cleaner syntax — no `break` needed.

```java
int day = 3;

String dayName = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    case 4 -> "Thursday";
    case 5 -> "Friday";
    case 6 -> "Saturday";
    case 7 -> "Sunday";
    default -> "Invalid";
};

System.out.println(dayName);  // Wednesday
```

---

## 🔟 if vs switch

```text
Use if-else when:
  → Range checks         (marks >= 90)
  → Boolean conditions   (isLoggedIn == true)
  → Multiple variables   (a > b && c < d)

Use switch when:
  → Single variable with fixed values (day == 1, 2, 3...)
  → Many exact matches
  → Cleaner readable code
```

---

## 🎯 Summary

| Statement | Use |
|---|---|
| `if` | Single condition check |
| `if-else` | True or false block |
| `if-else if` | Multiple condition ladder |
| Nested `if` | Condition inside condition |
| `switch` | One variable, many fixed values |
| `switch` expression | Java 14+, cleaner arrow syntax |
