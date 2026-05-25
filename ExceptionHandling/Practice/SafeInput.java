import java.util.Scanner;

public class SafeInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.nextLine();

        try {
            int num = Integer.parseInt(input);
            System.out.println("Valid number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("'" + input + "' is not a valid number");
        }
        sc.close();
    }
}