public class BitwiseOps {
    public static void main(String[] args) {

        int a = 5;   // binary: 0101
        int b = 3;   // binary: 0011

        System.out.println("a & b  = " + (a & b));   // 1  → AND  (0001)
        System.out.println("a | b  = " + (a | b));   // 7  → OR   (0111)
        System.out.println("a ^ b  = " + (a ^ b));   // 6  → XOR  (0110)
        System.out.println("~a     = " + (~a));       // -6 → NOT  (complement)
        System.out.println("a << 1 = " + (a << 1));  // 10 → left shift  (1010)
        System.out.println("a >> 1 = " + (a >> 1));  // 2  → right shift (0010)
    }
}