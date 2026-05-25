// Custom Exception class
class InsufficientBalanceException extends Exception {

    private double amount;

    InsufficientBalanceException(double amount) {
        super("Insufficient balance. Tried to withdraw: ₹" + amount);
        this.amount = amount;
    }

    double getAmount() { return amount; }
}

// Another custom exception
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) {
        super(message);
    }
}

class BankAccount {

    private double balance;

    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(amount);
        }
        balance -= amount;
        System.out.println("Withdrawn ₹" + amount + " | Balance: ₹" + balance);
    }
}

public class CustomException {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount(5000);

        try {
            acc.withdraw(2000);   // ok
            acc.withdraw(8000);   // throws InsufficientBalanceException
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
            System.out.println("Amount: ₹" + e.getAmount());
        }
    }
}

// Output:
// Withdrawn ₹2000.0 | Balance: ₹3000.0
// Exception: Insufficient balance. Tried to withdraw: ₹8000.0
// Amount: ₹8000.0