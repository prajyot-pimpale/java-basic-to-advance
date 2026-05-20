public class FallThrough {
    public static void main(String[] args) {

        int num = 2;

        // WITHOUT break → fall-through
        switch (num) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");   // ← starts here
            case 3:
                System.out.println("Three"); // ← also runs!
            default:
                System.out.println("Default"); // ← also runs!
        }
        // Output: Two, Three, Default  ← fall-through!

        System.out.println("---");

        // WITH break → stops at matched case
        switch (num) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");   // ← runs
                break;                       // ← stops here
            case 3:
                System.out.println("Three");
                break;
        }
        // Output: Two ✅
    }
}