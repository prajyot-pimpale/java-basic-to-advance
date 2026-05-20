public class UnaryOps {
    public static void main(String[] args) {

        int a = 5;

        // Unary plus and minus
        System.out.println(+a);   // 5
        System.out.println(-a);   // -5

        // Increment
        int x = 10;
        System.out.println(x++);  // 10 ← prints THEN increments (post)
        System.out.println(x);    // 11

        int y = 10;
        System.out.println(++y);  // 11 ← increments THEN prints (pre)
        System.out.println(y);    // 11

        // Decrement
        int p = 10;
        System.out.println(p--);  // 10 ← prints THEN decrements (post)
        System.out.println(p);    // 9

        int q = 10;
        System.out.println(--q);  // 9  ← decrements THEN prints (pre)
        System.out.println(q);    // 9

        // NOT operator
        boolean flag = true;
        System.out.println(!flag);  // false
    }
}