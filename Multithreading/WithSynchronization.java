// WITH synchronized — FIXED
class Counter {
    int count = 0;

    synchronized void increment() {  // only one thread at a time
        count++;
    }
}

// Now output will always be: Count: 2000 ✅

public class WithSynchronization {
    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("Count: " + c.count);
        // Expected: 2000  Actual: random (less than 2000) ← RACE CONDITION ❌
    }
}

