public class NestedLoop {
    public static void main(String[] args) {

        // Multiplication table
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
        // Output:
        // 1   2   3
        // 2   4   6
        // 3   6   9

        // Right triangle pattern
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // Output:
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
    }
}