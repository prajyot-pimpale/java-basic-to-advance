# 📘 Topic 19 — Stream API

---

## 1️⃣ What is Stream API?

```text
Functional-style operations on collections in a clean pipeline.

Stream is NOT a data structure
Stream does NOT store data
Stream processes data from a source (List, Set, Array)

Without Stream → multiple loops, temp variables, more code
With Stream    → single pipeline, readable, less code
```

---

## 2️⃣ Stream Pipeline

```text
Source → Intermediate Operations → Terminal Operation

List.stream()
    .filter(...)       ← intermediate
    .map(...)          ← intermediate
    .sorted(...)       ← intermediate
    .collect(...)      ← terminal (triggers execution)
```

---

## 3️⃣ Create a Stream

```java
import java.util.stream.*;

// From List
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> s1 = names.stream();

// From Array
Stream<String> s2 = Arrays.stream(new String[]{"Java", "Python"});

// From values
Stream<Integer> s3 = Stream.of(1, 2, 3, 4, 5);

// Infinite stream (limited)
Stream<Integer> s4 = Stream.iterate(0, n -> n + 2).limit(5);
s4.forEach(System.out::println);  // 0 2 4 6 8

// Generate
Stream<Double> s5 = Stream.generate(Math::random).limit(3);
s5.forEach(System.out::println);
```

---

## 4️⃣ `filter()` — Keep Matching Elements

```java
List<Integer> nums  = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
List<String>  names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Alex");

// Filter even numbers
List<Integer> evens = nums.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
System.out.println(evens);  // [2, 4, 6, 8, 10]

// Filter > 5
List<Integer> big = nums.stream()
    .filter(n -> n > 5)
    .collect(Collectors.toList());
System.out.println(big);    // [6, 7, 8, 9, 10]

// Filter strings starting with A
List<String> aNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());
System.out.println(aNames); // [Alice, Anna, Alex]
```

---

## 5️⃣ `map()` — Transform Each Element

```java
List<String> names = Arrays.asList("alice", "bob", "charlie");

// To uppercase
List<String> upper = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
System.out.println(upper);  // [ALICE, BOB, CHARLIE]

// Get lengths
List<Integer> lengths = names.stream()
    .map(String::length)
    .collect(Collectors.toList());
System.out.println(lengths);  // [5, 3, 7]

// Square numbers
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> squares = nums.stream()
    .map(n -> n * n)
    .collect(Collectors.toList());
System.out.println(squares);  // [1, 4, 9, 16, 25]
```

---

## 6️⃣ `sorted()` — Sort Elements

```java
List<Integer> nums  = Arrays.asList(5, 2, 8, 1, 9, 3);
List<String>  names = Arrays.asList("Charlie", "Alice", "Bob");

// Ascending
List<Integer> asc = nums.stream().sorted().collect(Collectors.toList());
System.out.println(asc);   // [1, 2, 3, 5, 8, 9]

// Descending
List<Integer> desc = nums.stream()
    .sorted(Comparator.reverseOrder())
    .collect(Collectors.toList());
System.out.println(desc);  // [9, 8, 5, 3, 2, 1]

// Sort strings
List<String> sorted = names.stream().sorted().collect(Collectors.toList());
System.out.println(sorted); // [Alice, Bob, Charlie]

// Sort by length
List<String> byLen = names.stream()
    .sorted(Comparator.comparingInt(String::length))
    .collect(Collectors.toList());
System.out.println(byLen);  // [Bob, Alice, Charlie]
```

---

## 7️⃣ `distinct()`, `limit()`, `skip()`

```java
List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);

// distinct
List<Integer> unique = nums.stream().distinct().collect(Collectors.toList());
System.out.println(unique);  // [1, 2, 3, 4, 5]

// limit → first N
List<Integer> first3 = nums.stream().limit(3).collect(Collectors.toList());
System.out.println(first3);  // [1, 2, 2]

// skip → skip first N
List<Integer> skip3 = nums.stream().skip(3).collect(Collectors.toList());
System.out.println(skip3);   // [3, 3, 4, 5, 5]

// Pagination (skip + limit)
List<Integer> page2 = nums.stream()
    .distinct().skip(2).limit(2)
    .collect(Collectors.toList());
System.out.println(page2);   // [3, 4]
```

---

## 8️⃣ Terminal Operations

```java
List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);

// count
long count = nums.stream().filter(n -> n > 3).count();
System.out.println("Count > 3: " + count);   // 4

// sum / average
int sum = nums.stream().mapToInt(Integer::intValue).sum();
System.out.println("Sum     : " + sum);       // 31

double avg = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
System.out.println("Average : " + avg);       // 3.875

// min / max
int max = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
int min = nums.stream().mapToInt(Integer::intValue).min().getAsInt();
System.out.println("Max: " + max + " | Min: " + min);  // Max: 9 | Min: 1

// findFirst
Optional<Integer> first = nums.stream().filter(n -> n > 5).findFirst();
System.out.println("First > 5: " + first.get());  // 9

// anyMatch / allMatch / noneMatch
System.out.println(nums.stream().anyMatch(n -> n > 8));    // true
System.out.println(nums.stream().allMatch(n -> n > 0));    // true
System.out.println(nums.stream().noneMatch(n -> n > 10));  // true

// reduce
int product = nums.stream().reduce(1, (a, b) -> a * b);
System.out.println("Product : " + product);   // 6480
```

---

## 9️⃣ `collect()` — Collectors

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Brian");

// toList / toSet
List<String> list = names.stream().collect(Collectors.toList());
Set<String>  set  = names.stream().collect(Collectors.toSet());

// joining
String joined = names.stream().collect(Collectors.joining(", "));
System.out.println(joined);   // Alice, Bob, Charlie, Anna, Brian

String joined2 = names.stream().collect(Collectors.joining(", ", "[", "]"));
System.out.println(joined2);  // [Alice, Bob, Charlie, Anna, Brian]

// groupingBy
Map<Integer, List<String>> byLen = names.stream()
    .collect(Collectors.groupingBy(String::length));
System.out.println(byLen);
// {3=[Bob], 4=[Anna], 5=[Alice, Brian], 7=[Charlie]}

// partitioningBy
Map<Boolean, List<String>> partition = names.stream()
    .collect(Collectors.partitioningBy(s -> s.startsWith("A")));
System.out.println("A names: " + partition.get(true));   // [Alice, Anna]
System.out.println("Others : " + partition.get(false));  // [Bob, Charlie, Brian]
```

---

## 1️⃣1️⃣ Intermediate vs Terminal

```text
Intermediate (lazy — run only when terminal is called):
  filter()   → keep matching elements
  map()      → transform elements
  sorted()   → sort
  distinct() → remove duplicates
  limit()    → first N elements
  skip()     → skip N elements
  peek()     → debug/inspect (like forEach but intermediate)
  flatMap()  → flatten nested streams

Terminal (trigger execution):
  collect()   → gather into List/Set/Map
  forEach()   → iterate
  count()     → number of elements
  sum()       → total
  average()   → mean
  min() / max() → smallest / largest
  findFirst() → first element
  anyMatch()  → any element matches?
  allMatch()  → all elements match?
  noneMatch() → no element matches?
  reduce()    → combine all into one
```

---

## 🎯 Summary

| Operation | Method | Type |
|---|---|---|
| Filter | `filter(predicate)` | Intermediate |
| Transform | `map(function)` | Intermediate |
| Sort | `sorted()` | Intermediate |
| Remove duplicates | `distinct()` | Intermediate |
| First N | `limit(n)` | Intermediate |
| Skip N | `skip(n)` | Intermediate |
| Collect to List | `collect(Collectors.toList())` | Terminal |
| Count | `count()` | Terminal |
| Sum | `mapToInt().sum()` | Terminal |
| Match | `anyMatch()` `allMatch()` | Terminal |
| Reduce | `reduce(identity, accumulator)` | Terminal |
| Group by | `collect(Collectors.groupingBy())` | Terminal |