public class IfElseDemo {
    public static void main(String[] args) {

        int age = 15;

        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }

        // Even or odd
        int num = 7;
        if (num % 2 == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }

        // Positive or negative
        int n = -5;
        if (n >= 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
}