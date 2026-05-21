public class ArrayOps {
    public static void main(String[] args) {

        int[] arr = {5, 3, 8, 1, 9, 2};

        // Sum and Average
        int sum = 0;
        for (int n : arr) sum += n;
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + (double) sum / arr.length);

        // Max and Min
        int max = arr[0], min = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
            if (n < min) min = n;
        }
        System.out.println("Max: " + max);  // 9
        System.out.println("Min: " + min);  // 1

        // Linear Search
        int target = 8;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println("Found at index: " + i);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Not found");

        // Reverse array
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");  // 2 9 1 8 3 5
        }
    }
}