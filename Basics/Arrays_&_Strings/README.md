# 📘 Topic 6 — Arrays & Strings

---

## 1️⃣ What is an Array?

```text
A collection of same type elements stored in contiguous memory.

int[] marks = {90, 85, 78, 92, 88};

Index →    0    1    2    3    4
Value →   90   85   78   92   88

- Fixed size (can't grow or shrink)
- Index starts from 0
- Same data type only
```

---

## 2️⃣ Declare, Create & Initialize

```java
// Method 1 — Declare and create
int[] arr = new int[5];   // default 0
arr[0] = 10;
arr[1] = 20;

// Method 2 — Declare and initialize
int[] marks = {90, 85, 78, 92, 88};

// Method 3 — new with values
String[] names = new String[]{"Alice", "Bob", "Charlie"};

// Length
System.out.println(marks.length);  // 5
```

---

## 3️⃣ Access & Traverse Array

```java
int[] nums = {10, 20, 30, 40, 50};

// Access by index
System.out.println(nums[0]);  // 10
System.out.println(nums[4]);  // 50

// for loop
for (int i = 0; i < nums.length; i++) {
    System.out.println("Index " + i + " = " + nums[i]);
}

// for-each
for (int n : nums) {
    System.out.print(n + " ");  // 10 20 30 40 50
}
```

---

## 4️⃣ Array Operations

```java
int[] arr = {5, 3, 8, 1, 9, 2};

// Sum and Average
int sum = 0;
for (int n : arr) sum += n;
System.out.println("Sum: " + sum);
System.out.println("Avg: " + (double) sum / arr.length);

// Max and Min
int max = arr[0], min = arr[0];
for (int n : arr) {
    if (n > max) max = n;
    if (n < min) min = n;
}
System.out.println("Max: " + max);  // 9
System.out.println("Min: " + min);  // 1

// Linear Search
int target = 8;
for (int i = 0; i < arr.length; i++) {
    if (arr[i] == target) {
        System.out.println("Found at index: " + i);
        break;
    }
}

// Reverse print
for (int i = arr.length - 1; i >= 0; i--) {
    System.out.print(arr[i] + " ");  // 2 9 1 8 3 5
}
```

---

## 5️⃣ 2D Arrays

Array of arrays — like a table (rows & columns).

```java
// Initialize
int[][] grid = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Access
System.out.println(grid[0][0]);  // 1
System.out.println(grid[1][2]);  // 6
System.out.println(grid[2][1]);  // 8

// Traverse
for (int i = 0; i < grid.length; i++) {
    for (int j = 0; j < grid[i].length; j++) {
        System.out.print(grid[i][j] + " ");
    }
    System.out.println();
}
// Output:
// 1 2 3
// 4 5 6
// 7 8 9
```

---

## 6️⃣ Arrays Utility Class

```java
import java.util.Arrays;

int[] arr = {5, 3, 8, 1, 9, 2};

// ToString
System.out.println(Arrays.toString(arr)); // [5, 3, 8, 1, 9, 2]

// Sort
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));   // [1, 2, 3, 5, 8, 9]

// Binary Search (array must be sorted)
int idx = Arrays.binarySearch(arr, 8);
System.out.println("8 at index: " + idx);   // 4

// Fill
int[] filled = new int[5];
Arrays.fill(filled, 7);
System.out.println(Arrays.toString(filled)); // [7, 7, 7, 7, 7]

// Copy
int[] copy = Arrays.copyOf(arr, arr.length);
System.out.println(Arrays.toString(copy));  // [5, 3, 8, 1, 9, 2]

// Copy Of Range
int[] copyRange = Arrays.copyOfRange(arr, 1, 4);
System.out.println(Arrays.toString(copyRange));  // [3, 8, 1]

// Compare
System.out.println(Arrays.equals(arr, copy));  // true

// Deep To String
int[][] matrix = {
            {1, 2},
            {3, 4}
        };

System.out.println(Arrays.deepToString(matrix)); // [[1, 2], [3, 4]]
```
---

| Method | Purpose |
|---|---|
| `Arrays.toString()` | Convert array to string |
| `Arrays.sort()` | Sort array |
| `Arrays.binarySearch()` | Search element |
| `Arrays.equals()` | Compare arrays |
| `Arrays.fill()` | Fill array |
| `Arrays.copyOf()` | Copy array |
| `Arrays.copyOfRange()` | Copy specific range |
| `Arrays.deepToString()` | Print multidimensional array |

---

## 7️⃣ What is a String?

```text
A sequence of characters — non-primitive, immutable object.

String name = "Alice";
               A l i c e
index →        0 1 2 3 4

Immutable → once created, value cannot be changed
  String s = "Hello";
  s = "World";  ← creates a NEW object, doesn't modify old one
```

---

## 8️⃣ String Methods

```java
String s = "Hello World";

s.length()                    // 11
s.toUpperCase()               // HELLO WORLD
s.toLowerCase()               // hello world
s.trim()                      // removes leading/trailing spaces
s.charAt(0)                   // H
s.charAt(6)                   // W
s.indexOf("World")            // 6
s.indexOf("z")                // -1 (not found)
s.substring(6)                // World
s.substring(0, 5)             // Hello
s.replace("World", "Java")    // Hello Java
s.contains("World")           // true
s.startsWith("Hello")         // true
s.endsWith("World")           // true
s.isEmpty()                   // false
s.equals("Hello World")       // true

// Split
String csv = "apple,mango,banana";
String[] fruits = csv.split(",");
// fruits = ["apple", "mango", "banana"]
```

---

## 9️⃣ String Methods Cheat Sheet

| Method | Description | Output |
|---|---|---|
| `length()` | length of string | 4 |
| `charAt(i)` | char at index | 'a' |
| `indexOf(s)` | first position of s | 1 |
| `substring(i)` | from index to end | "va" |
| `substring(i,j)` | from i to j (j excluded) | "Ja" |
| `toUpperCase()` | all caps | "JAVA" |
| `toLowerCase()` | all lower | "java" |
| `trim()` | remove spaces | "hi" |
| `replace(a,b)` | replace a with b | "bat" |
| `contains(s)` | check if exists | true |
| `equals(s)` | compare value | true |
| `split(s)` | split into array | ["a","b"] |
| `isEmpty()` | check if empty | true |

---

## 🔟 equals() vs ==

```java
String a = "hello";
String b = "hello";
String c = new String("hello");

System.out.println(a.equals(b));  // true  ✅ compares value
System.out.println(a == b);       // true  (same string pool)
System.out.println(a.equals(c));  // true  ✅
System.out.println(a == c);       // false ❌ different objects

// Always use .equals() to compare Strings
```

---

## 1️⃣1️⃣ StringBuilder

Use when you need to modify strings frequently.

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" World");        // Hello World
sb.insert(5, ",");          // Hello, World
sb.replace(7, 12, "Java");  // Hello, Java
sb.delete(5, 6);            // Hello Java
sb.reverse();               // avaJ olleH

System.out.println(sb.length());  // 10
```

```text
String        → immutable, new object on every change
StringBuilder → mutable, modifies same object (faster)
StringBuffer  → mutable, thread-safe (slower)
```

---

## 🎯 Summary

| Topic | Key Point |
|---|---|
| Array | Fixed size, same type, index from 0 |
| 2D Array | Table structure, row and column |
| `Arrays` class | sort, search, fill, copy, equals |
| String | Immutable, sequence of characters |
| String methods | length, charAt, substring, split, replace |
| `equals()` | Always use for String comparison, not `==` |
| StringBuilder | Mutable String, faster for modifications |