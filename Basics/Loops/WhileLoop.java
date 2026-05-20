public class WhileLoop {
    public static void main(String[] args) {

        // Print 1 to 5
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        // Sum of digits
        int num = 12345;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;  // get last digit
            num /= 10;        // remove last digit
        }
        System.out.println("Sum of digits: " + sum);  // 15

        // User input until 0
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = -1;
        while (n != 0) {
            System.out.print("Enter number (0 to stop): ");
            n = sc.nextInt();
        }
    }
}