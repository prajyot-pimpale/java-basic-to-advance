# 📘 Topic 20 — Lambda Expressions (Deep Dive)

---

## 1️⃣ What is a Lambda Expression?

```text
A short, anonymous function — no name, no class, written inline.

Before Java 8 → Anonymous inner class (verbose)
Java 8 Lambda → Concise, readable, powerful

Lambda = Functional Interface Implementation
```

---

## 2️⃣ Lambda Syntax — All Forms

```java
// No parameter
() -> System.out.println("Hello")

// One parameter
name -> System.out.println(name)

// Multiple parameters
(a, b) -> a + b

// With type declaration
(int a, int b) -> a + b

// Multiple statements
(a, b) -> {
    int sum = a + b;
    System.out.println("Sum: " + sum);
    return sum;
}

// Single expression → no return keyword needed
(a, b) -> a + b
```

---

## 3️⃣ Lambda vs Anonymous Class

```java
// Anonymous class ❌ verbose
Comparator<String> comp1 = new Comparator<String>() {
    @Override
    public int compare(String a, String b) { return a.compareTo(b); }
};

// Lambda ✅ clean
Comparator<String> comp2 = (a, b) -> a.compareTo(b);

// Method reference ✅ even shorter
Comparator<String> comp3 = String::compareTo;
```

```java
// Thread — anonymous class
Thread t1 = new Thread(new Runnable() {
    @Override
    public void run() { System.out.println("Running"); }
});

// Thread — lambda
Thread t2 = new Thread(() -> System.out.println("Running"));
t2.start();
```

---

## 4️⃣ Lambda with Custom Functional Interfaces

```java
@FunctionalInterface interface Greeting  { String greet(String name); }
@FunctionalInterface interface MathOp    { int operate(int a, int b); }
@FunctionalInterface interface Check     { boolean test(int n); }
```

```java
// Greeting
Greeting formal   = name -> "Good Morning, " + name + "!";
Greeting casual   = name -> "Hey " + name + "!";
Greeting shouting = name -> "HELLO " + name.toUpperCase() + "!!!";

System.out.println(formal.greet("Alice"));     // Good Morning, Alice!
System.out.println(casual.greet("Bob"));       // Hey Bob!
System.out.println(shouting.greet("Charlie")); // HELLO CHARLIE!!!

// MathOp
MathOp add = (a, b) -> a + b;
MathOp pow = (a, b) -> (int) Math.pow(a, b);

System.out.println(add.operate(10, 3));  // 13
System.out.println(pow.operate(2, 8));   // 256

// Check (with multi-line lambda)
Check isPrime = n -> {
    if (n < 2) return false;
    for (int i = 2; i <= Math.sqrt(n); i++)
        if (n % i == 0) return false;
    return true;
};
System.out.println(isPrime.test(17));  // true
System.out.println(isPrime.test(10));  // false
```

---

## 5️⃣ Lambda as Method Parameter

```java
// Method accepts Predicate lambda
static List<Integer> filter(List<Integer> list, Predicate<Integer> cond) {
    List<Integer> result = new ArrayList<>();
    for (int n : list) if (cond.test(n)) result.add(n);
    return result;
}

// Method accepts Function lambda
static void process(String val, Function<String, String> transform) {
    System.out.println(transform.apply(val));
}
```

```java
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Pass different lambdas to same method
System.out.println(filter(nums, n -> n % 2 == 0)); // [2,4,6,8,10]
System.out.println(filter(nums, n -> n > 5));       // [6,7,8,9,10]
System.out.println(filter(nums, n -> n % 3 == 0));  // [3,6,9]

// Transform
process("hello",       s -> s.toUpperCase());           // HELLO
process("  java  ",    s -> s.trim());                  // java
process("hello world", s -> s.replace(" ", "_"));      // hello_world
```

---

## 6️⃣ Lambda Capturing Variables

```java
// Local variable → must be effectively final
String prefix = "Hello";
Runnable r = () -> System.out.println(prefix + " World");
r.run();  // Hello World
// prefix = "Hi";  ← ERROR! cannot modify captured variable

// Workaround for mutable counter
int[] count = {0};
Runnable counter = () -> {
    count[0]++;
    System.out.println("Count: " + count[0]);
};
counter.run();  // Count: 1
counter.run();  // Count: 2

// Instance variable → no restriction
int instanceVar = 100;
Runnable r2 = () -> {
    instanceVar += 10;  // ✅ allowed
    System.out.println(instanceVar);
};
```

---

## 7️⃣ Chaining Lambdas

```java
// Function chaining
Function<Integer, Integer> times2 = n -> n * 2;
Function<Integer, Integer> plus10 = n -> n + 10;

// andThen → first then second
Function<Integer, Integer> t2ThenP10 = times2.andThen(plus10);
System.out.println(t2ThenP10.apply(5));  // (5*2)+10 = 20

// compose → second first, then first
Function<Integer, Integer> p10ThenT2 = times2.compose(plus10);
System.out.println(p10ThenT2.apply(5));  // (5+10)*2 = 30

// Chain multiple functions
Function<String, String> pipeline = ((Function<String,String>) String::trim)
    .andThen(String::toLowerCase)
    .andThen(s -> s.replace(" ", "_"));
System.out.println(pipeline.apply("  Hello World  ")); // hello_world

// Predicate chaining
Predicate<Integer> isEven     = n -> n % 2 == 0;
Predicate<Integer> isPositive = n -> n > 0;
Predicate<Integer> isSmall    = n -> n < 100;

Predicate<Integer> combined = isEven.and(isPositive).and(isSmall);
System.out.println(combined.test(4));    // true
System.out.println(combined.test(-4));   // false

// negate
Predicate<Integer> isOdd = isEven.negate();
System.out.println(isOdd.test(3));   // true

// or
Predicate<String> isBlank = ((Predicate<String>) String::isEmpty)
    .or(s -> s.trim().isEmpty());
System.out.println(isBlank.test(""));    // true
System.out.println(isBlank.test("  ")); // true
System.out.println(isBlank.test("hi")); // false
```

---

## 8️⃣ Lambda with Collections

```java
List<String> names = new ArrayList<>(
    Arrays.asList("Charlie", "Alice", "Bob", "Diana", "Eve")
);

// Sort by length then alphabetically
names.sort(Comparator
    .comparingInt(String::length)
    .thenComparing(Comparator.naturalOrder()));
System.out.println(names);  // [Bob, Eve, Alice, Diana, Charlie]

// removeIf
List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
nums.removeIf(n -> n % 2 == 0);
System.out.println(nums);  // [1, 3, 5]

// replaceAll
List<String> words = new ArrayList<>(Arrays.asList("hello","world","java"));
words.replaceAll(String::toUpperCase);
System.out.println(words); // [HELLO, WORLD, JAVA]

// Map merge — count occurrences
Map<String, Integer> scores = new HashMap<>();
String[] attempts = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};
for (String name : attempts)
    scores.merge(name, 1, Integer::sum);
System.out.println(scores); // {Alice=3, Bob=2, Charlie=1}
```

---

## 9️⃣ Comparator with Lambda

```java
List<Employee> employees = Arrays.asList(
    new Employee("Alice",   "IT",  75000),
    new Employee("Bob",     "HR",  55000),
    new Employee("Charlie", "IT",  90000),
    new Employee("Diana",   "HR",  65000)
);

// Sort by salary ascending
employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

// Sort by dept then name
employees.sort(Comparator
    .comparing((Employee e) -> e.dept)
    .thenComparing(e -> e.name));

// Sort by salary descending
employees.sort(Comparator
    .comparingDouble((Employee e) -> e.salary).reversed());

System.out.println("Top earner: " + employees.get(0).name);
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Lambda syntax | `(params) -> body` |
| No param | `() -> body` |
| Multi-line | `(params) -> { statements; return val; }` |
| Capture variable | Must be effectively final |
| As parameter | Pass behavior, not just data |
| `andThen()` | Chain functions — first then second |
| `compose()` | Chain functions — second then first |
| `and()` `or()` `negate()` | Chain predicates |
| `removeIf()` | Remove matching elements from list |
| `replaceAll()` | Transform all elements in list |