import java.util.Scanner;

public class GradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();

        String grade = (marks >= 90) ? "A" :
                       (marks >= 75) ? "B" :
                       (marks >= 60) ? "C" :
                       (marks >= 50) ? "D" : "F";

        System.out.println("Grade: " + grade);
        String status = (marks >= 50) ? "PASS" : "FAIL";
        System.out.println("Status: " + status);
        sc.close();
    }
}