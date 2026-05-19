import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Sum     : " + (a + b));
        System.out.println("Diff    : " + (a - b));
        System.out.println("Product : " + (a * b));
        System.out.println("Division: " + (a / b));

        sc.close();
    }
}