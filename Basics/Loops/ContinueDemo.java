public class ContinueDemo {
    public static void main(String[] args) {

        // Skip even numbers
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;  // skip even
            System.out.print(i + " ");  // 1 3 5 7 9
        }

        // Skip a specific value
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            System.out.print(i + " ");  // 1 2 4 5
        }
    }
}