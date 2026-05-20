public class IfElseIfDemo {
    public static void main(String[] args) {

        int marks = 72;

        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 60) {
            System.out.println("Grade: C");
        } else if (marks >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F  → Fail");
        }

        // Output: Grade: C
    }
}