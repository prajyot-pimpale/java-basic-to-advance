public class BankAccount {

    private String accountNumber;
    private String owner;
    private double balance;
    private String pin;
    private int    failedAttempts;

    // Constructor
    public BankAccount(String accNo, String owner, double initialBalance, String pin) {
        this.accountNumber  = accNo;
        this.owner          = owner;
        this.balance        = initialBalance;
        this.pin            = pin;
        this.failedAttempts = 0;
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getOwner()         { return owner; }

    public double getBalance(String pin) {
        if (validatePin(pin)) return balance;
        else { System.out.println("Wrong PIN"); return -1; }
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " | Balance: ₹" + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw with PIN check
    public void withdraw(double amount, String pin) {
        if (!validatePin(pin)) {
            System.out.println("Wrong PIN! Access denied");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + " | Balance: ₹" + balance);
        }
    }

    // Private helper
    private boolean validatePin(String inputPin) {
        if (inputPin.equals(this.pin)) {
            failedAttempts = 0;
            return true;
        }
        failedAttempts++;
        if (failedAttempts >= 3)
            System.out.println("Account locked after 3 failed attempts!");
        return false;
    }

    public void display() {
        System.out.println("Account: " + accountNumber + " | Owner: " + owner);
    }
}