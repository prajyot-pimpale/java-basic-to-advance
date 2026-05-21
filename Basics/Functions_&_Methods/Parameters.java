public class Parameters {
    public static void main(String[] args) {

        // Single parameter
        printDouble(5);          // 10

        // Multiple parameters
        System.out.println(add(3, 4));       // 7
        System.out.println(fullName("John", "Doe")); // John Doe

        // Array as parameter
        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr);
    }

    static void printDouble(int n) {
        System.out.println(n * 2);
    }

    static int add(int a, int b) {
        return a + b;
    }

    static String fullName(String first, String last) {
        return first + " " + last;
    }

    static void printArray(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }
}