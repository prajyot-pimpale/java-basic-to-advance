import java.util.Scanner;

public class MethodCalc {

    static double add(double a, double b)      { return a + b; }
    static double subtract(double a, double b) { return a - b; }
    static double multiply(double a, double b) { return a * b; }
    static double divide(double a, double b)   {
        if (b == 0) { System.out.println("Cannot divide by zero"); return 0; }
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");   double a = sc.nextDouble();
        System.out.print("Enter op: ");  char op = sc.next().charAt(0);
        System.out.print("Enter b: ");   double b = sc.nextDouble();

        double result = switch (op) {
            case '+' -> add(a, b);
            case '-' -> subtract(a, b);
            case '*' -> multiply(a, b);
            case '/' -> divide(a, b);
            default  -> { System.out.println("Invalid"); yield 0; }
        };

        System.out.println("Result: " + result);
        sc.close();
    }
}