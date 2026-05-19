public class NarrowingCast {
    public static void main(String[] args) {

        double d = 9.99;
        int i = (int) d;    // manually cast → decimal part cut off
        System.out.println("double: " + d);  // 9.99
        System.out.println("int: " + i);     // 9  ← decimal lost!

        long l = 1000L;
        int x = (int) l;    // long → int
        System.out.println("int from long: " + x);  // 1000
    }
}