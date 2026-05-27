class BankAccount {

    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    void deposit(double amount) {
        synchronized (this) {      // lock this object
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

public class SynchronizationBlock {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);

        Thread t1 = new Thread(() -> acc.deposit(500),  "User-1");
        Thread t2 = new Thread(() -> acc.withdraw(300), "User-2");
        Thread t3 = new Thread(() -> acc.deposit(200),  "User-3");

        t1.start(); t2.start(); t3.start();
    }
}
