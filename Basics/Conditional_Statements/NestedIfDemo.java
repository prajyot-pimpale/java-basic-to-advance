public class NestedIfDemo {
    public static void main(String[] args) {

        int age = 20;
        boolean hasID = true;

        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry allowed");
            } else {
                System.out.println("No ID, entry denied");
            }
        } else {
            System.out.println("Underage, entry denied");
        }

        // Loan eligibility
        int salary = 50000;
        int creditScore = 750;

        if (salary >= 30000) {
            if (creditScore >= 700) {
                System.out.println("Loan Approved");
            } else {
                System.out.println("Low credit score");
            }
        } else {
            System.out.println("Salary too low");
        }
    }
}