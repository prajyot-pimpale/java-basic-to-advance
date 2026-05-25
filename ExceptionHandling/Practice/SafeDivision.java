import java.util.Scanner;

public class SafeDivision {

    static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a: "); double a = sc.nextDouble();
            System.out.print("Enter b: "); double b = sc.nextDouble();
            System.out.println("Result: " + divide(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}