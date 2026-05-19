public class CommanMistakes{
    public static void main(string[] args){
        
        // ❌ MISTAKE 1: int overflow
        int x = 2147483647;
        x = x + 1;
        System.out.println(x);  // -2147483648 ← wraps around! use long

        // ❌ MISTAKE 2: integer division
        int a = 5, b = 2;
        System.out.println(a / b);       // 2 (not 2.5!)
        System.out.println(a / (double)b); // 2.5 ✅

        // ❌ MISTAKE 3: float precision
        float f = 0.1f + 0.2f;
        System.out.println(f);   // 0.3 (looks ok)
        double d = 0.1 + 0.2;
        System.out.println(d);   // 0.30000000000000004 ← use BigDecimal for money

        // ❌ MISTAKE 4: mixing nextInt and nextLine
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        sc.nextLine();           // ← consume leftover newline
        String name = sc.nextLine();  // now works correctly
        
    }
}