# 📘 Topic 18 — Java 8 Features

---

## 1️⃣ What's New in Java 8?

```text
Key Features:
  1. Lambda Expressions
  2. Functional Interfaces
  3. Stream API
  4. Default & Static methods in Interface
  5. Optional Class
  6. Method References
  7. Date & Time API (java.time)
  8. forEach() method
```

---

## 2️⃣ Lambda Expressions

Short way to write anonymous functions.

```java
// Before Java 8
Runnable r = new Runnable() {
    @Override
    public void run() { System.out.println("Running..."); }
};

// Java 8 Lambda
Runnable r = () -> System.out.println("Running...");
r.run();
```

```text
Lambda Syntax:
  ()          -> expression          // no param
  (param)     -> expression          // one param
  (p1, p2)    -> expression          // multiple params
  (p1, p2)    -> { statements; }    // multiple lines
```

```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

// Sort with lambda
names.sort((a, b) -> a.compareTo(b));
System.out.println(names);  // [Alice, Bob, Charlie]

// forEach with lambda
names.forEach(name -> System.out.println("Hello, " + name));

// Sort numbers
List<Integer> nums = Arrays.asList(5, 2, 8, 1, 9);
nums.sort((a, b) -> a - b);
System.out.println(nums);  // [1, 2, 5, 8, 9]
```

---

## 3️⃣ Functional Interface

Interface with exactly one abstract method.

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface Validator {
    boolean validate(String input);
}
```

```java
MathOperation add      = (a, b) -> a + b;
MathOperation subtract = (a, b) -> a - b;
MathOperation multiply = (a, b) -> a * b;

System.out.println(add.operate(10, 5));       // 15
System.out.println(subtract.operate(10, 5));  // 5
System.out.println(multiply.operate(10, 5));  // 50

Validator emailCheck = email -> email.contains("@") && email.contains(".");
System.out.println(emailCheck.validate("alice@mail.com"));  // true
System.out.println(emailCheck.validate("invalid"));         // false
```

---

## 4️⃣ Built-in Functional Interfaces

```java
import java.util.function.*;

// Predicate<T> → takes T, returns boolean
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4));   // true
System.out.println(isEven.test(7));   // false

// Predicate chaining
Predicate<Integer> isPositive = n -> n > 0;
Predicate<Integer> evenAndPos = isEven.and(isPositive);
System.out.println(evenAndPos.test(4));   // true
System.out.println(evenAndPos.test(-4));  // false

// Function<T,R> → takes T, returns R
Function<String, Integer> strLen  = s -> s.length();
Function<Integer, String> intToStr = n -> "Number: " + n;

System.out.println(strLen.apply("Hello"));  // 5
System.out.println(intToStr.apply(42));     // Number: 42

// Function chaining
Function<String, String> trimThenUpper = ((Function<String,String>) String::trim)
                                          .andThen(String::toUpperCase);
System.out.println(trimThenUpper.apply("  hello  ")); // HELLO

// Consumer<T> → takes T, returns nothing
Consumer<String> print  = s -> System.out.println(s);
Consumer<String> printU = s -> System.out.println(s.toUpperCase());

print.accept("Hello Java");   // Hello Java
printU.accept("Hello Java");  // HELLO JAVA

// Supplier<T> → no input, returns T
Supplier<String>  greeting = () -> "Hello World!";
Supplier<Integer> random   = () -> (int)(Math.random() * 100);

System.out.println(greeting.get());  // Hello World!
System.out.println(random.get());    // random number

// BiFunction<T,U,R>
BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);
System.out.println(repeat.apply("Java ", 3));  // Java Java Java
```

### Built-in Interfaces Cheat Sheet

| Interface | Input | Output | Method |
|---|---|---|---|
| `Predicate<T>` | T | boolean | `test()` |
| `Function<T,R>` | T | R | `apply()` |
| `Consumer<T>` | T | void | `accept()` |
| `Supplier<T>` | none | T | `get()` |
| `BiFunction<T,U,R>` | T, U | R | `apply()` |
| `UnaryOperator<T>` | T | T | `apply()` |
| `BinaryOperator<T>` | T, T | T | `apply()` |

---

## 5️⃣ Method References

Shorthand for lambdas that call existing methods.

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// Lambda
names.forEach(name -> System.out.println(name));

// Method reference (same thing, shorter)
names.forEach(System.out::println);

// Static method reference
Function<String, Integer> parse = Integer::parseInt;
System.out.println(parse.apply("42"));  // 42

// Instance method reference
String str = "Hello World";
Supplier<String> upper = str::toUpperCase;
System.out.println(upper.get());  // HELLO WORLD

// Constructor reference
Supplier<ArrayList> listFactory = ArrayList::new;
ArrayList<String> list = listFactory.get();
```

```text
Types:
  Static method    → ClassName::staticMethod
  Instance method  → object::instanceMethod
  Arbitrary object → ClassName::instanceMethod
  Constructor      → ClassName::new
```

---

## 6️⃣ Optional Class

Avoid NullPointerException with Optional wrapper.

```java
import java.util.Optional;

Optional<String> opt1 = Optional.of("Hello");       // not null
Optional<String> opt2 = Optional.empty();           // empty
Optional<String> opt3 = Optional.ofNullable(null);  // may be null

System.out.println(opt1.isPresent());   // true
System.out.println(opt2.isPresent());   // false
System.out.println(opt2.isEmpty());     // true

System.out.println(opt1.get());                        // Hello
System.out.println(opt2.orElse("Default"));            // Default
System.out.println(opt2.orElseGet(() -> "Generated")); // Generated

opt1.ifPresent(val -> System.out.println("Value: " + val)); // Value: Hello

Optional<Integer> length = opt1.map(String::length);
System.out.println(length.get());  // 5
```

```java
// Real use — avoid NullPointerException
static Optional<String> findUser(int id) {
    if (id == 1) return Optional.of("Alice");
    return Optional.empty();
}

findUser(1).ifPresent(u -> System.out.println("Found: " + u)); // Found: Alice
String name = findUser(99).orElse("Guest");
System.out.println(name);  // Guest
```

---

## 7️⃣ New Date & Time API

```java
import java.time.*;
import java.time.format.DateTimeFormatter;

LocalDate  today = LocalDate.now();        // 2024-01-15
LocalTime  now   = LocalTime.now();        // 14:30:25
LocalDateTime dt = LocalDateTime.now();   // 2024-01-15T14:30:25

// Specific date
LocalDate dob = LocalDate.of(2000, 6, 15);

// Date arithmetic
LocalDate nextWeek  = today.plusDays(7);
LocalDate lastMonth = today.minusMonths(1);

// Compare
System.out.println(today.isAfter(dob));   // true

// Format
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
System.out.println(today.format(fmt));    // 15-01-2024

// Period (age)
Period age = Period.between(dob, today);
System.out.println("Age: " + age.getYears() + " years");
```

---

## 8️⃣ forEach with Collections

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

// forEach with lambda
names.forEach(name -> System.out.println(name));

// Method reference
names.forEach(System.out::println);

// HashMap forEach
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob",   80);

scores.forEach((name, score) ->
    System.out.println(name + " → " + score));
```

---

## 🎯 Summary

| Feature | Key Point |
|---|---|
| Lambda | Short anonymous function `(params) -> body` |
| Functional Interface | One abstract method, used with lambda |
| `Predicate<T>` | Returns boolean — `test()` |
| `Function<T,R>` | Transforms T to R — `apply()` |
| `Consumer<T>` | Consumes T, no return — `accept()` |
| `Supplier<T>` | No input, returns T — `get()` |
| Method Reference | `ClassName::method` shorthand |
| `Optional<T>` | Avoid NullPointerException |
| Date/Time API | `LocalDate`, `LocalTime`, `LocalDateTime` |
| `forEach` | Iterate with lambda or method reference |