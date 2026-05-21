public class ArrayDemo {
    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 40, 50};

        // Access by index
        System.out.println(nums[0]);  // 10
        System.out.println(nums[4]);  // 50

        // Traverse using for loop
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Index " + i + " = " + nums[i]);
        }

        // Traverse using for-each
        for (int n : nums) {
            System.out.print(n + " ");  // 10 20 30 40 50
        }
    }
}