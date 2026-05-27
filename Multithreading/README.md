# 📘 Topic 16 — Multithreading

---

## 1️⃣ What is Multithreading?

```text
Thread → smallest unit of execution inside a program

Single-threaded:  Task1 → Task2 → Task3  (one at a time)
Multi-threaded:   Task1 ↘
                  Task2 → runs simultaneously
                  Task3 ↗

Real World:
  → Browser loads page + plays video + downloads file
  → App handles multiple users at same time
  → Background music while playing game

Benefits:
  → Better CPU utilization
  → Faster execution
  → Responsive UI
  → Handle multiple tasks simultaneously
```

---

## 2️⃣ Thread Life Cycle

```text
NEW → RUNNABLE → RUNNING → BLOCKED/WAITING → TERMINATED

NEW        → Thread object created, not started
RUNNABLE   → start() called, ready to run
RUNNING    → CPU is executing the thread
BLOCKED    → waiting for resource or lock
WAITING    → waiting for another thread (join/sleep)
TERMINATED → thread finished execution
```

---

## 3️⃣ Create Thread — Method 1: Extend Thread

```java
class MyThread extends Thread {
    String name;

    MyThread(String name) { this.name = name; }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " → " + i);
            try { Thread.sleep(500); }
            catch (InterruptedException e) { System.out.println(name + " interrupted"); }
        }
    }
}
```

```java
MyThread t1 = new MyThread("Thread-A");
MyThread t2 = new MyThread("Thread-B");

t1.start();  // ✅ creates new thread, calls run()
t2.start();

// Output (interleaved):
// Thread-A → 1
// Thread-B → 1
// Thread-A → 2 ...
```

```text
t1.run()   → runs in SAME thread (NOT multithreading) ❌
t1.start() → creates NEW thread, calls run() in it    ✅
```

---

## 4️⃣ Create Thread — Method 2: Implement Runnable

```java
class MyTask implements Runnable {
    String taskName;

    MyTask(String name) { this.taskName = name; }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " step " + i +
                               " [" + Thread.currentThread().getName() + "]");
            try { Thread.sleep(300); }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
```

```java
Thread t1 = new Thread(new MyTask("Download"));
Thread t2 = new Thread(new MyTask("Upload"));

t1.start();
t2.start();
```

```text
Runnable preferred because:
  → Java supports single inheritance only
  → Class can still extend another class
  → Better separation of task from thread management
```

---

## 5️⃣ Lambda Thread (Java 8+)

```java
Thread t1 = new Thread(() -> {
    for (int i = 1; i <= 3; i++)
        System.out.println("Thread-1: " + i);
});

Thread t2 = new Thread(() -> {
    for (int i = 1; i <= 3; i++)
        System.out.println("Thread-2: " + i);
});

t1.start();
t2.start();
```

---

## 6️⃣ Thread Methods

```java
Thread t = new Thread(() -> { /* task */ });

t.setName("MyWorker");
System.out.println(t.getName());       // MyWorker

t.setPriority(Thread.MAX_PRIORITY);   // 10
System.out.println(t.getPriority());   // 10

t.start();
System.out.println(t.isAlive());       // true

t.join();                              // wait for t to finish
System.out.println(t.isAlive());       // false

System.out.println(Thread.currentThread().getName()); // main
```

### Thread Methods Cheat Sheet

| Method | Description |
|---|---|
| `start()` | Start thread execution |
| `run()` | Thread task (don't call directly) |
| `sleep(ms)` | Pause thread for milliseconds |
| `join()` | Wait for thread to finish |
| `getName()` | Get thread name |
| `setName()` | Set thread name |
| `getPriority()` | Get priority (1-10) |
| `setPriority()` | Set priority |
| `isAlive()` | Check if thread is running |
| `interrupt()` | Interrupt a sleeping thread |

---

## 7️⃣ Thread Synchronization

When multiple threads access shared resource, data can get corrupted.

```java
// WITHOUT sync → RACE CONDITION ❌
class Counter {
    int count = 0;
    void increment() { count++; }  // not thread-safe!
}

// Expected: 2000 | Actual: random < 2000 ❌
```

```java
// WITH synchronized → FIXED ✅
class Counter {
    int count = 0;

    synchronized void increment() {  // one thread at a time
        count++;
    }
}

// Output always: Count: 2000 ✅
```

---

## 8️⃣ `synchronized` Block

Lock only the critical section, not entire method.

```java
class BankAccount {
    private double balance;

    BankAccount(double balance) { this.balance = balance; }

    void deposit(double amount) {
        synchronized (this) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() +
                               " deposited ₹" + amount +
                               " | Balance: ₹" + balance);
        }
    }

    void withdraw(double amount) {
        synchronized (this) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() +
                                   " withdrew ₹" + amount +
                                   " | Balance: ₹" + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        }
    }
}
```

```java
BankAccount acc = new BankAccount(1000);

Thread t1 = new Thread(() -> acc.deposit(500),  "User-1");
Thread t2 = new Thread(() -> acc.withdraw(300), "User-2");
Thread t3 = new Thread(() -> acc.deposit(200),  "User-3");

t1.start(); t2.start(); t3.start();
```

---

## 9️⃣ Inter-thread Communication

```java
class SharedBox {
    int     value;
    boolean hasValue = false;

    synchronized void produce(int val) throws InterruptedException {
        while (hasValue) wait();       // wait if full
        value    = val;
        hasValue = true;
        System.out.println("Produced: " + val);
        notify();                       // notify consumer
    }

    synchronized int consume() throws InterruptedException {
        while (!hasValue) wait();      // wait if empty
        hasValue = false;
        System.out.println("Consumed: " + value);
        notify();                       // notify producer
        return value;
    }
}
```

```java
SharedBox box = new SharedBox();

Thread producer = new Thread(() -> {
    try {
        for (int i = 1; i <= 5; i++) box.produce(i);
    } catch (InterruptedException e) { e.printStackTrace(); }
});

Thread consumer = new Thread(() -> {
    try {
        for (int i = 1; i <= 5; i++) box.consume();
    } catch (InterruptedException e) { e.printStackTrace(); }
});

producer.start();
consumer.start();

// Produced: 1 | Consumed: 1
// Produced: 2 | Consumed: 2 ...
```

---

## 🎯 Summary

| Concept | Key Point |
|---|---|
| Thread | Smallest unit of execution |
| `extends Thread` | One way to create thread |
| `implements Runnable` | Preferred way (allows extends) |
| `start()` | Starts new thread (never call `run()` directly) |
| `sleep(ms)` | Pause thread for milliseconds |
| `join()` | Wait for thread to complete |
| `synchronized` | Prevents race condition on shared data |
| `wait()` / `notify()` | Inter-thread communication |
| Lambda Thread | `new Thread(() -> { ... }).start()` |