public class ForEachLoop {
    public static void main(String[] args) {

        // Array iteration
        int[] nums = {10, 20, 30, 40, 50};

        for (int n : nums) {
            System.out.println(n);
        }

        // String array
        String[] fruits = {"Apple", "Mango", "Banana"};

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}