public class DoWhileLoop {
    public static void main(String[] args) {

        // Runs at least once even if condition is false
        int i = 10;
        do {
            System.out.println(i);  // prints 10
            i++;
        } while (i <= 5);           // condition false, but ran once

        // Menu driven program
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Hello");
            System.out.println("2. World");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
        } while (choice != 3);

        System.out.println("Exited!");
    }
}