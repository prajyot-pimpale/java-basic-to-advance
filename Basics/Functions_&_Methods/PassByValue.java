public class PassByValue {
    public static void main(String[] args) {

        // Primitive — pass by value (copy)
        int x = 10;
        change(x);
        System.out.println(x);  // still 10 ← original not changed

        // Array — reference is copied (original CAN change)
        int[] arr = {1, 2, 3};
        changeArray(arr);
        System.out.println(arr[0]);  // 99 ← changed!
    }

    static void change(int n) {
        n = 99;  // only local copy changes
    }

    static void changeArray(int[] arr) {
        arr[0] = 99;  // modifies original array
    }
}