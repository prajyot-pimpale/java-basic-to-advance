@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);   // single abstract method
}

@FunctionalInterface
interface Greeting {
    void greet(String name);
}

@FunctionalInterface
interface Validator {
    boolean validate(String input);
}

public class FunctionalDemo {
    public static void main(String[] args) {

        // Lambda implements functional interface
        MathOperation add      = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Add     : " + add.operate(10, 5));       // 15
        System.out.println("Subtract: " + subtract.operate(10, 5));  // 5
        System.out.println("Multiply: " + multiply.operate(10, 5));  // 50

        Greeting formal   = name -> System.out.println("Good Morning, " + name);
        Greeting informal = name -> System.out.println("Hey, " + name + "!");

        formal.greet("Alice");    // Good Morning, Alice
        informal.greet("Bob");    // Hey, Bob!

        Validator emailCheck = email -> email.contains("@") && email.contains(".");
        System.out.println(emailCheck.validate("alice@mail.com"));  // true
        System.out.println(emailCheck.validate("invalid-email"));   // false
    }
}