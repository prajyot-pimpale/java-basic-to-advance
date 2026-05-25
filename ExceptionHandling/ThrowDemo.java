public class ThrowDemo {

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18+. Got: " + age);
        }
        System.out.println("Access granted. Age: " + age);
    }

    static void checkBalance(double balance, double amount) {
        if (amount > balance) {
            throw new ArithmeticException("Insufficient balance");
        }
        System.out.println("Transaction successful");
    }

    public static void main(String[] args) {

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

        checkAge(20);  // Access granted. Age: 20
    }
}