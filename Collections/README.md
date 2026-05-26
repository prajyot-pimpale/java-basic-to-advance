# 📘 Topic 14 — Collections Framework

---

## 1️⃣ What is Collections Framework?

```text
Ready-made data structures to store and manipulate groups of objects.

Array Problems:          Collections Solution:
  Fixed size        →     Dynamic size
  No built-in sort  →     Built-in methods
  Limited features  →     Powerful and flexible
```

### Hierarchy

```text
Collection (Interface)
│
├── List (ordered, duplicates allowed)
│     ├── ArrayList
│     ├── LinkedList
│     └── Vector
│
├── Set (no duplicates)
│     ├── HashSet
│     ├── LinkedHashSet
│     └── TreeSet
│
└── Queue
      ├── PriorityQueue
      └── LinkedList

Map (key-value pairs) — separate hierarchy
      ├── HashMap
      ├── LinkedHashMap
      └── TreeMap
```

---

## 2️⃣ ArrayList

Dynamic array — grows automatically.

```java
import java.util.ArrayList;

ArrayList<String> fruits = new ArrayList<>();

// Add
fruits.add("Apple");
fruits.add("Mango");
fruits.add("Banana");
fruits.add("Apple");         // duplicates allowed
fruits.add(1, "Grapes");     // add at index

// Get
System.out.println(fruits.get(0));  // Apple

// Update
fruits.set(1, "Kiwi");

// Remove
fruits.remove(0);            // by index
fruits.remove("Banana");     // by value

// Utility
System.out.println(fruits.size());            // size
System.out.println(fruits.contains("Mango")); // true
System.out.println(fruits.indexOf("Apple"));  // index

// Iterate
for (String fruit : fruits) {
    System.out.print(fruit + " ");
}
```

---

## 3️⃣ ArrayList — Sorting & Utilities

```java
import java.util.Collections;

ArrayList<Integer> nums = new ArrayList<>();
nums.add(5); nums.add(2); nums.add(8); nums.add(1); nums.add(9);

Collections.sort(nums);                          // [1, 2, 5, 8, 9]
Collections.sort(nums, Collections.reverseOrder()); // [9, 8, 5, 2, 1]

System.out.println(Collections.min(nums));  // 1
System.out.println(Collections.max(nums));  // 9
Collections.shuffle(nums);                  // random order

nums.add(5);
System.out.println(Collections.frequency(nums, 5));  // 2

nums.clear();
System.out.println(nums.isEmpty());  // true
```

---

## 4️⃣ LinkedList

Doubly linked list — fast insert/delete.

```java
import java.util.LinkedList;

LinkedList<String> list = new LinkedList<>();

list.add("B");
list.addFirst("A");   // add at beginning → [A, B]
list.addLast("C");    // add at end       → [A, B, C]

System.out.println(list.getFirst());  // A
System.out.println(list.getLast());   // C

list.removeFirst();
list.removeLast();
System.out.println(list);  // [B]

// As Queue (FIFO)
LinkedList<String> queue = new LinkedList<>();
queue.offer("First");
queue.offer("Second");
System.out.println(queue.poll());  // First  (removes)
System.out.println(queue.peek());  // Second (just looks)

// As Stack (LIFO)
LinkedList<String> stack = new LinkedList<>();
stack.push("One");
stack.push("Two");
stack.push("Three");
System.out.println(stack.pop());   // Three (removes top)
System.out.println(stack.peek());  // Two   (just looks)
```

---

## 5️⃣ ArrayList vs LinkedList

```text
┌─────────────────┬─────────────────────┬─────────────────────┐
│                 │     ArrayList       │    LinkedList       │
├─────────────────┼─────────────────────┼─────────────────────┤
│ Structure       │ Dynamic array       │ Doubly linked list  │
│ Access (get)    │ O(1) — fast         │ O(n) — slow         │
│ Insert/Delete   │ O(n) — slow         │ O(1) — fast         │
│ Memory          │ Less                │ More (node pointers)│
│ Use when        │ More reads          │ More insert/delete  │
└─────────────────┴─────────────────────┴─────────────────────┘
```

---

## 6️⃣ HashSet

No duplicates, no order.

```java
import java.util.HashSet;

HashSet<String> set = new HashSet<>();

set.add("Apple");
set.add("Mango");
set.add("Banana");
set.add("Apple");   // duplicate → ignored

System.out.println(set);               // [Banana, Apple, Mango] (no order)
System.out.println(set.size());        // 3
System.out.println(set.contains("Mango")); // true

set.remove("Banana");

// Remove duplicates from List
ArrayList<Integer> withDups = new ArrayList<>(Arrays.asList(1,2,1,3,2));
HashSet<Integer> unique = new HashSet<>(withDups);
System.out.println(unique);  // [1, 2, 3]
```

---

## 7️⃣ LinkedHashSet & TreeSet

```java
import java.util.LinkedHashSet;
import java.util.TreeSet;

// LinkedHashSet → no duplicates, INSERTION ORDER maintained
LinkedHashSet<String> lhs = new LinkedHashSet<>();
lhs.add("Banana");
lhs.add("Apple");
lhs.add("Mango");
lhs.add("Apple");  // ignored
System.out.println(lhs);  // [Banana, Apple, Mango]

// TreeSet → no duplicates, SORTED ORDER
TreeSet<Integer> ts = new TreeSet<>();
ts.add(5); ts.add(1); ts.add(8); ts.add(3);
System.out.println(ts);           // [1, 3, 5, 8]
System.out.println(ts.first());   // 1
System.out.println(ts.last());    // 8
System.out.println(ts.headSet(5)); // [1, 3] → less than 5
System.out.println(ts.tailSet(5)); // [5, 8] → 5 and above
```

---

## 8️⃣ HashMap

Key-value pairs, no order, no duplicate keys.

```java
import java.util.HashMap;

HashMap<String, Integer> marks = new HashMap<>();

// Put
marks.put("Alice",   95);
marks.put("Bob",     80);
marks.put("Charlie", 75);
marks.put("Alice",   98);  // updates existing key

// Get
System.out.println(marks.get("Alice"));             // 98
System.out.println(marks.get("Unknown"));           // null
System.out.println(marks.getOrDefault("X", 0));    // 0

// Check
System.out.println(marks.containsKey("Bob"));      // true
System.out.println(marks.containsValue(75));       // true

// Remove
marks.remove("Charlie");

// Iterate keys
for (String key : marks.keySet()) {
    System.out.println(key + " → " + marks.get(key));
}

// Iterate key-value pairs
for (var entry : marks.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Iterate values
for (int val : marks.values()) {
    System.out.println(val);
}
```

---

## 9️⃣ LinkedHashMap & TreeMap

```java
import java.util.LinkedHashMap;
import java.util.TreeMap;

// LinkedHashMap → key-value, INSERTION ORDER
LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
lhm.put("Banana", 3);
lhm.put("Apple",  1);
lhm.put("Mango",  2);
System.out.println(lhm);  // {Banana=3, Apple=1, Mango=2}

// TreeMap → key-value, SORTED BY KEY
TreeMap<String, Integer> tm = new TreeMap<>();
tm.put("Banana", 3);
tm.put("Apple",  1);
tm.put("Mango",  2);
System.out.println(tm);           // {Apple=1, Banana=3, Mango=2}
System.out.println(tm.firstKey()); // Apple
System.out.println(tm.lastKey());  // Mango
```

---

## 🔟 Collections — Quick Comparison

```text
┌────────────────┬──────────┬────────────┬────────────┐
│ Collection     │  Order   │ Duplicates │ Null Key   │
├────────────────┼──────────┼────────────┼────────────┤
│ ArrayList      │ Insertion│ ✅ Yes     │ ✅ Yes     │
│ LinkedList     │ Insertion│ ✅ Yes     │ ✅ Yes     │
│ HashSet        │ No order │ ❌ No      │ ✅ One     │
│ LinkedHashSet  │ Insertion│ ❌ No      │ ✅ One     │
│ TreeSet        │ Sorted   │ ❌ No      │ ❌ No      │
│ HashMap        │ No order │ Keys ❌    │ ✅ Yes     │
│ LinkedHashMap  │ Insertion│ Keys ❌    │ ✅ Yes     │
│ TreeMap        │ Sorted   │ Keys ❌    │ ❌ No      │
└────────────────┴──────────┴────────────┴────────────┘
```

---

## 🎯 Summary

| Collection | Key Feature |
|---|---|
| `ArrayList` | Dynamic array, fast access, allows duplicates |
| `LinkedList` | Fast insert/delete, used as queue/stack |
| `HashSet` | No duplicates, no order |
| `LinkedHashSet` | No duplicates, insertion order |
| `TreeSet` | No duplicates, sorted order |
| `HashMap` | Key-value, no order, fast lookup |
| `LinkedHashMap` | Key-value, insertion order |
| `TreeMap` | Key-value, sorted by key |