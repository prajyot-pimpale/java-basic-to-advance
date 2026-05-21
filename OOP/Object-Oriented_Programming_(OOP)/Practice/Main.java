public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", 1000);
        acc.display();
        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000);  // Insufficient balance
        acc.display();
    }
}