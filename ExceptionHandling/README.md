# 📘 Topic 13 — Exception Handling

---

## 1️⃣ What is an Exception?

```text
An unexpected event that disrupts normal program flow.

Examples:
  int a = 10 / 0;                  → ArithmeticException
  arr[10] = 1;                     → ArrayIndexOutOfBoundsException
  String s = null; s.length();     → NullPointerException
  Integer.parseInt("abc");         → NumberFormatException

Without handling → program CRASHES
With handling    → program runs GRACEFULLY
```

---

## 2️⃣ Exception Hierarchy

```text
Throwable
│
├── Error (serious, don't handle)
│     ├── StackOverflowError
│     ├── OutOfMemoryError
│     └── VirtualMachineError
│
└── Exception (handle these)
      │
      ├── Checked (compile-time)
      │     ├── IOException
      │     ├── SQLException
      │     └── FileNotFoundException
      │
      └── Unchecked (runtime)
            ├── ArithmeticException
            ├── NullPointerException
            ├── ArrayIndexOutOfBoundsException
            ├── NumberFormatException
            └── ClassCastException
```

---

## 3️⃣ try-catch Block

```java
try {
    // risky code
} catch (ExceptionType e) {
    // handle exception
}
```

```java
try {
    int result = 10 / 0;
    System.out.println("Result: " + result);  // skipped
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());  // / by zero
}

System.out.println("Program continues...");  // still runs ✅
```

---

## 4️⃣ Multiple catch Blocks

```java
try {
    int x = 10 / 0;
    // arr[10];                 // ArrayIndexOutOfBoundsException
    // str.length();            // NullPointerException
    // Integer.parseInt("abc"); // NumberFormatException

} catch (ArithmeticException e) {
    System.out.println("Arithmetic: " + e.getMessage());
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array index: " + e.getMessage());
} catch (NullPointerException e) {
    System.out.println("Null pointer error");
} catch (NumberFormatException e) {
    System.out.println("Number format: " + e.getMessage());
} catch (Exception e) {
    System.out.println("General error: " + e.getMessage()); // LAST
}
```

```text
Order matters:
  Specific exceptions → FIRST
  General Exception   → LAST
```

---

## 5️⃣ `finally` Block

Executes always — whether exception occurs or not.

```java
try {
    System.out.println("try block");
    int x = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("catch: " + e.getMessage());
} finally {
    System.out.println("finally → always runs");
}

// Output:
// try block
// catch: / by zero
// finally → always runs
```

```text
finally is used for:
  → Closing files and database connections
  → Releasing resources
  → Cleanup code
```

---

## 6️⃣ `throw` Keyword

Manually throw an exception.

```java
static void checkAge(int age) {
    if (age < 18)
        throw new IllegalArgumentException("Age must be 18+. Got: " + age);
    System.out.println("Access granted. Age: " + age);
}

static void checkBalance(double balance, double amount) {
    if (amount > balance)
        throw new ArithmeticException("Insufficient balance");
    System.out.println("Transaction successful");
}
```

```java
try {
    checkAge(15);
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
}

try {
    checkBalance(1000, 5000);
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
}
```

---

## 7️⃣ `throws` Keyword

Declare that a method may throw an exception — caller must handle it.

```java
static void readFile(String path) throws FileNotFoundException {
    FileReader fr = new FileReader(path);  // may throw
    System.out.println("File opened");
}

static int divide(int a, int b) throws ArithmeticException {
    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
    return a / b;
}
```

```java
try {
    readFile("test.txt");
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
}
```

```text
throw  → actually throws the exception object
throws → declares that method might throw (warning to caller)
```

---

## 8️⃣ Custom Exception

Create your own exception class.

```java
// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    private double amount;

    InsufficientBalanceException(double amount) {
        super("Insufficient balance. Tried to withdraw: ₹" + amount);
        this.amount = amount;
    }

    double getAmount() { return amount; }
}

// Custom Unchecked Exception
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) { super(message); }
}
```

```java
class BankAccount {
    private double balance;
    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance)
            throw new InsufficientBalanceException(amount);
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + " | Balance: ₹" + balance);
    }
}
```

```java
BankAccount acc = new BankAccount(5000);

try {
    acc.withdraw(2000);  // ok
    acc.withdraw(8000);  // throws
} catch (InsufficientBalanceException e) {
    System.out.println("Exception: " + e.getMessage());
    System.out.println("Amount: ₹" + e.getAmount());
}

// Withdrawn ₹2000.0 | Balance: ₹3000.0
// Exception: Insufficient balance. Tried to withdraw: ₹8000.0
```

---

## 9️⃣ try-with-resources (Java 7+)

Auto-closes resources after use.

```java
try (FileReader fr = new FileReader("test.txt");
     BufferedReader br = new BufferedReader(fr)) {

    String line;
    while ((line = br.readLine()) != null)
        System.out.println(line);

} catch (IOException e) {
    System.out.println("IO Error: " + e.getMessage());
}
// fr and br closed automatically ✅
```

```text
Resource must implement AutoCloseable or Closeable.
Java automatically calls close() after try block ends.
```

---

## 🔟 Checked vs Unchecked

```text
Checked Exception:
  → Checked at COMPILE time
  → Must handle with try-catch OR throws
  → Examples: IOException, SQLException, FileNotFoundException

Unchecked Exception:
  → Checked at RUNTIME
  → Handling is optional
  → Examples: NullPointerException, ArithmeticException

Error:
  → Serious system-level problems
  → Should NOT be handled
  → Examples: StackOverflowError, OutOfMemoryError
```

---

## 1️⃣1️⃣ Common Exceptions Cheat Sheet

| Exception | Cause |
|---|---|
| `ArithmeticException` | Division by zero |
| `NullPointerException` | Using null reference |
| `ArrayIndexOutOfBoundsException` | Invalid array index |
| `NumberFormatException` | Invalid number format |
| `ClassCastException` | Invalid type cast |
| `StackOverflowError` | Infinite recursion |
| `FileNotFoundException` | File doesn't exist |
| `IOException` | Input/output failure |
| `SQLException` | Database error |

---

## 🎯 Summary

| Keyword | Use |
|---|---|
| `try` | Wrap risky code |
| `catch` | Handle specific exception |
| `finally` | Always runs, used for cleanup |
| `throw` | Manually throw an exception |
| `throws` | Declare method may throw exception |
| Custom Exception | Extend `Exception` or `RuntimeException` |
| Checked | Must handle at compile time |
| Unchecked | Optional handling at runtime |