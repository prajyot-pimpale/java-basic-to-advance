public class BreakDemo {
    public static void main(String[] args) {

        // Stop at 5
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;
            System.out.print(i + " ");  // 1 2 3 4
        }

        // Search in array
        int[] arr = {3, 7, 1, 9, 4};
        int target = 9;
        boolean found = false;

        for (int n : arr) {
            if (n == target) {
                found = true;
                break;  // no need to check further
            }
        }
        System.out.println(target + (found ? " found" : " not found"));
    }
}