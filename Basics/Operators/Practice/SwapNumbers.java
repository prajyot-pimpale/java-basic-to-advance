public class SwapNumbers {
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println("Before: a=" + a + ", b=" + b);

        // Swap using third variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After : a=" + a + ", b=" + b);

        // Swap WITHOUT third variable (using arithmetic)
        int x = 5, y = 8;
        x = x + y;  // x = 13
        y = x - y;  // y = 5
        x = x - y;  // x = 8
        System.out.println("Swapped: x=" + x + ", y=" + y);
    }
}