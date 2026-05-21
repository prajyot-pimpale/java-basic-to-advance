public class ArrayDeclarationAndInitialization{
    public static void main(String[] args){
        // Method 1 — Declare and create
        int[] arr = new int[5];   // creates array of size 5 (default 0)
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        // Method 2 — Declare and initialize
        int[] marks = {90, 85, 78, 92, 88};

        // Method 3 — new keyword with values
        String[] names = new String[]{"Alice", "Bob", "Charlie"};

        // Get length
        System.out.println(marks.length);  // 5
    }
}