public class FinallyDemo {
    public static void main(String[] args) {

        try {
            System.out.println("try block");
            int x = 10 / 0;              // exception here
            System.out.println("after exception");  // skipped
        } catch (ArithmeticException e) {
            System.out.println("catch block: " + e.getMessage());
        } finally {
            System.out.println("finally block → always runs");
        }

        System.out.println("after try-catch-finally");
    }
}

// Output:
// try block
// catch block: / by zero
// finally block → always runs
// after try-catch-finally