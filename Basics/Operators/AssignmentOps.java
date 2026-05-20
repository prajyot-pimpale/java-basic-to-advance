public class AssignmentOps {
    public static void main(String[] args) {

        int a = 10;         // basic assignment

        a += 5;   System.out.println("a += 5  → " + a);  // 15  (a = a + 5)
        a -= 3;   System.out.println("a -= 3  → " + a);  // 12  (a = a - 3)
        a *= 2;   System.out.println("a *= 2  → " + a);  // 24  (a = a * 2)
        a /= 4;   System.out.println("a /= 4  → " + a);  // 6   (a = a / 4)
        a %= 4;   System.out.println("a %= 4  → " + a);  // 2   (a = a % 4)
    }
}