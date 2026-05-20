# 📘 Topic 5 — Loops

---

## 1️⃣ What are Loops?

```text
Loops execute a block of code repeatedly until a condition is met.

Types:
1. for loop
2. while loop
3. do-while loop
4. for-each loop

Control Statements:
5. break
6. continue
7. Nested loops
```

---

## 2️⃣ `for` Loop

Use when you know how many times to repeat.

```java
for (initialization; condition; update) {
    // body
}
```

```java
// Print 1 to 5
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

// Print 5 to 1 (reverse)
for (int i = 5; i >= 1; i--) {
    System.out.println(i);
}

// Print even numbers 1 to 10
for (int i = 2; i <= 10; i += 2) {
    System.out.print(i + " ");  // 2 4 6 8 10
}
```

### Execution Flow

```text
for (int i = 1; i <= 5; i++)
  Step 1: int i = 1   → initialization (only once)
  Step 2: i <= 5 ?    → check condition
  Step 3: run body
  Step 4: i++         → update
  Step 5: go to Step 2
```

---

## 3️⃣ `while` Loop

Use when you don't know how many times to repeat.

```java
while (condition) {
    // body
}
```

```java
// Print 1 to 5
int i = 1;
while (i <= 5) {
    System.out.println(i);
    i++;
}

// Sum of digits
int num = 12345, sum = 0;
while (num != 0) {
    sum += num % 10;  // get last digit
    num /= 10;        // remove last digit
}
System.out.println("Sum of digits: " + sum);  // 15
```

---

## 4️⃣ `do-while` Loop

Executes at least once, then checks condition.

```java
do {
    // body
} while (condition);
```

```java
// Runs at least once even if condition is false
int i = 10;
do {
    System.out.println(i);  // prints 10
    i++;
} while (i <= 5);           // condition false, but ran once

// Menu driven program
Scanner sc = new Scanner(System.in);
int choice;
do {
    System.out.println("1. Hello");
    System.out.println("2. World");
    System.out.println("3. Exit");
    System.out.print("Enter choice: ");
    choice = sc.nextInt();
} while (choice != 3);
```

---

## 5️⃣ for vs while vs do-while

```text
┌─────────────┬──────────────────────────────────┐
│    Loop     │          Use When                │
├─────────────┼──────────────────────────────────┤
│   for       │ Count is known  (1 to 10)        │
│   while     │ Count unknown, condition based    │
│   do-while  │ Must run at least once (menus)    │
└─────────────┴──────────────────────────────────┘
```

---

## 6️⃣ `for-each` Loop

Used to iterate over arrays and collections.

```java
// Array iteration
int[] nums = {10, 20, 30, 40, 50};
for (int n : nums) {
    System.out.println(n);
}

// String array
String[] fruits = {"Apple", "Mango", "Banana"};
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

```text
for (dataType variable : arrayName)
      ↑          ↑           ↑
    type      each item    collection
```

---

## 7️⃣ `break` Statement

Exits the loop immediately.

```java
// Stop at 5
for (int i = 1; i <= 10; i++) {
    if (i == 5) break;
    System.out.print(i + " ");  // 1 2 3 4
}

// Search in array
int[] arr = {3, 7, 1, 9, 4};
int target = 9;
boolean found = false;

for (int n : arr) {
    if (n == target) {
        found = true;
        break;  // no need to check further
    }
}
System.out.println(target + (found ? " found" : " not found"));
```

---

## 8️⃣ `continue` Statement

Skips current iteration, continues with next.

```java
// Skip even numbers
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue;
    System.out.print(i + " ");  // 1 3 5 7 9
}

// Skip a specific value
for (int i = 1; i <= 5; i++) {
    if (i == 3) continue;
    System.out.print(i + " ");  // 1 2 4 5
}
```

```text
break    → exits loop completely
continue → skips current iteration only
```

---

## 9️⃣ Nested Loops

Loop inside another loop.

```java
// Multiplication table
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
// Output:
// 1   2   3
// 2   4   6
// 3   6   9

// Right triangle pattern
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}
// Output:
// *
// * *
// * * *
// * * * *
// * * * * *
```

---

## 🔟 Star Patterns

```java
int n = 5;

// Pattern 1 — Right Triangle
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++)
        System.out.print("* ");
    System.out.println();
}

// Pattern 2 — Inverted Triangle
for (int i = n; i >= 1; i--) {
    for (int j = 1; j <= i; j++)
        System.out.print("* ");
    System.out.println();
}

// Pattern 3 — Number Triangle
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= i; j++)
        System.out.print(j + " ");
    System.out.println();
}
// Output:
// 1
// 1 2
// 1 2 3
// 1 2 3 4
// 1 2 3 4 5

// Pattern 4 — Square
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++)
        System.out.print("* ");
    System.out.println();
}
```

---

## 🎯 Summary

| Loop | Use |
|---|---|
| `for` | Known count |
| `while` | Unknown count, condition based |
| `do-while` | Runs at least once |
| `for-each` | Arrays and collections |
| `break` | Exit loop immediately |
| `continue` | Skip current iteration |
| Nested loops | Loop inside loop (patterns, tables) |