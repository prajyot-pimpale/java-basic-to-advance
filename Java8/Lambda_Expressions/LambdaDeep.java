@FunctionalInterface
interface Greeting {
    String greet(String name);
}

@FunctionalInterface
interface MathOp {
    int operate(int a, int b);
}

@FunctionalInterface
interface Check {
    boolean test(int n);
}

public class LambdaDeep {
    public static void main(String[] args) {

        // Different implementations via lambda
        Greeting formal   = name -> "Good Morning, " + name + "!";
        Greeting casual   = name -> "Hey " + name + "!";
        Greeting shouting = name -> "HELLO " + name.toUpperCase() + "!!!";

        System.out.println(formal.greet("Alice"));    // Good Morning, Alice!
        System.out.println(casual.greet("Bob"));      // Hey Bob!
        System.out.println(shouting.greet("Charlie")); // HELLO CHARLIE!!!

        // Math operations
        MathOp add  = (a, b) -> a + b;
        MathOp sub  = (a, b) -> a - b;
        MathOp mul  = (a, b) -> a * b;
        MathOp div  = (a, b) -> b != 0 ? a / b : 0;
        MathOp pow  = (a, b) -> (int) Math.pow(a, b);

        System.out.println(add.operate(10, 3));  // 13
        System.out.println(pow.operate(2, 8));   // 256

        // Checks
        Check isEven    = n -> n % 2 == 0;
        Check isPrime   = n -> {
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++)
                if (n % i == 0) return false;
            return true;
        };
        Check isPositive = n -> n > 0;

        System.out.println(isEven.test(4));     // true
        System.out.println(isPrime.test(17));   // true
        System.out.println(isPositive.test(-3)); // false
    }
}