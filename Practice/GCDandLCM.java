public class GCDandLCM {
    public static void main(String[] args) {
     System.out.println(gcd(12,18));
     System.out.println();
     System.out.println(lcm(12,18));
    }
    static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
    }
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    // gcd(12, 18) = 6 | lcm(12, 18) = 36
}
