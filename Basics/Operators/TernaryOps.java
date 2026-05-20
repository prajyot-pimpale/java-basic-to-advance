public class TernaryOps {
    public static void main(String[] args) {

        int a = 10, b = 20;

        // Find maximum
        int max = (a > b) ? a : b;
        System.out.println("Max = " + max);  // 20

        // Check even or odd
        int num = 7;
        String result = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println(num + " is " + result);  // 7 is Odd

        // Check pass or fail
        int marks = 75;
        String status = (marks >= 50) ? "Pass" : "Fail";
        System.out.println("Status: " + status);  // Pass

        // Nested ternary (use sparingly)
        int score = 59;
        String grade = (score >= 90) ? "A" :
                       (score >= 75) ? "B" :
                       (score >= 60) ? "C" : "F";
        System.out.println("Grade: " + grade);  // B
    }
}