public class ForLoop {
    public static void main(String[] args) {

        // Print 1 to 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Print 5 to 1 (reverse)
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }

        // Print even numbers 1 to 10
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + " ");  // 2 4 6 8 10
        }
    }
}