public class FibRecursion {

    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("Fibonacci: ");
        for (int i = 0; i < 10; i++)
            System.out.print(fib(i) + " ");
        // Output: 0 1 1 2 3 5 8 13 21 34
    }
}