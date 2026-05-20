public class RelationalOps {
    public static void main(String[] args) {

        int a = 10, b = 5;

        System.out.println(a > b);    // true  → greater than
        System.out.println(a < b);    // false → less than
        System.out.println(a >= 10);  // true  → greater than or equal
        System.out.println(a <= 9);   // false → less than or equal
        System.out.println(a == b);   // false → equal to
        System.out.println(a != b);   // true  → not equal to

        // Common use: in conditions
        int age = 18;
        System.out.println(age >= 18);  // true → eligible to vote
    }
}