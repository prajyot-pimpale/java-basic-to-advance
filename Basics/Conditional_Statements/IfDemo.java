public class IfDemo {
    public static void main(String[] args) {

        int age = 20;

        if (age >= 18) {
            System.out.println("You are eligible to vote");
        }

        int marks = 80;

        if (marks >= 50) {
            System.out.println("Pass");
        }

        // No output if condition is false
        if (marks > 90) {
            System.out.println("This won't print");
        }
    }
}