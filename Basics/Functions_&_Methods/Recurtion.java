public class Recursion {
    public static void main(String[] args) {

        System.out.println(factorial(5));   // 120
        System.out.println(fibonacci(7));   // 13
        System.out.println(power(2, 8));    // 256
    }

    // Factorial
    static long factorial(int n) {
        if (n == 0 || n == 1) return 1;  // base case
        return n * factorial(n - 1);     // recursive call
    }
    // factorial(5) = 5 * factorial(4)
    //              = 5 * 4 * factorial(3)
    //              = 5 * 4 * 3 * 2 * 1 = 120

    // Fibonacci
    static int fibonacci(int n) {
        if (n <= 1) return n;            // base case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Power
    static long power(int base, int exp) {
        if (exp == 0) return 1;          // base case
        return base * power(base, exp - 1);
    }
}

/*
  
  Every recursion needs:
  1. Base case  → stops the recursion
  2. Recursive call → calls itself with smaller input

*/