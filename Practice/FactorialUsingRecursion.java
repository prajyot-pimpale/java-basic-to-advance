public class FactorialUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
    static long factorial(int n) {
        return (n == 0 || n == 1) ? 1 : n * factorial(n - 1);
    } 
}
