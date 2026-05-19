import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        final double PI = 3.14159;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double area = PI * radius * radius;
        double circumference = 2 * PI * radius;

        System.out.printf("Area         : %.2f%n", area);
        System.out.printf("Circumference: %.2f%n", circumference);

        sc.close();
    }
}