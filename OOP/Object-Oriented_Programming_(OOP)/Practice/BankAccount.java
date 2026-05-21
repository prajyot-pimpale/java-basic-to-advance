public class BankAccount {

    private String owner;
    private double balance;

    BankAccount(String owner, double balance) {
        this.owner   = owner;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    void withdraw(double amount) {
        if (amount > balance)
            System.out.println("Insufficient balance");
        else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void display() {
        System.out.println("Owner  : " + owner);
        System.out.println("Balance: " + balance);
    }
}