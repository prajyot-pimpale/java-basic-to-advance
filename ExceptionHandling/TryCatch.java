public class TryCatch {
    public static void main(String[] args) {

        // Without try-catch → program crashes
        // int result = 10 / 0;  ← ArithmeticException: / by zero

        // With try-catch → handled gracefully
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);  // never prints
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());  // / by zero
        }

        System.out.println("Program continues...");  // still runs ✅
    }
}