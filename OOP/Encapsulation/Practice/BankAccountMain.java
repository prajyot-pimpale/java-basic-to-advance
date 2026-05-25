public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("SBI001", "Alice", 10000, "1234");

        acc.display();
        acc.deposit(5000);
        acc.withdraw(3000, "1234");    // correct PIN
        acc.withdraw(3000, "9999");    // wrong PIN
        System.out.println("Balance: ₹" + acc.getBalance("1234"));
    }
}

// Output:
// Account: SBI001 | Owner: Alice
// Deposited ₹5000.0 | Balance: ₹15000.0
// Withdrawn ₹3000.0 | Balance: ₹12000.0
// Wrong PIN! Access denied
// Balance: ₹12000.0