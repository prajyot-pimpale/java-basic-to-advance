import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        String result = (n % 2 == 0) ? "Even" : "Odd";
        System.out.println(n + " is " + result);
        sc.close();
    }
}