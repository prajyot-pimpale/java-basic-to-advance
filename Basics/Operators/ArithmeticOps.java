public class ArithmeticOps {
    public static void main(String[] args) {

        int a = 10, b = 3;

        System.out.println("a + b = " + (a + b));   // 13  → Addition
        System.out.println("a - b = " + (a - b));   // 7   → Subtraction
        System.out.println("a * b = " + (a * b));   // 30  → Multiplication
        System.out.println("a / b = " + (a / b));   // 3   → Division (integer)
        System.out.println("a % b = " + (a % b));   // 1   → Modulus (remainder)

        // With doubles
        double x = 10.0, y = 3.0;
        System.out.println("x / y = " + (x / y));   // 3.3333...

        // Modulus use case: check even/odd
        System.out.println(10 % 2);  // 0 → even
        System.out.println(7  % 2);  // 1 → odd
    }
}
