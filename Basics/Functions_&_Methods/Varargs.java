public class Varargs {
    public static void main(String[] args) {

        System.out.println(sum(1, 2));          // 3
        System.out.println(sum(1, 2, 3));       // 6
        System.out.println(sum(1, 2, 3, 4, 5)); // 15
    }

    // int... means zero or more int arguments
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums)
            total += n;
        return total;
    }
}