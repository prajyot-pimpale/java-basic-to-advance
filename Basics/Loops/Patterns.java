public class Patterns {
    public static void main(String[] args) {

        int n = 5;

        // Pattern 1 — Right Triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        // Pattern 2 — Inverted Triangle
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }

        // Pattern 3 — Number Triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
        // Output:
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5

        // Pattern 4 — Square
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}