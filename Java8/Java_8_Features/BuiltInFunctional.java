import java.util.function.*;

public class BuiltInFunctional {
    public static void main(String[] args) {

        // Predicate<T> → takes T, returns boolean
        Predicate<Integer> isEven    = n -> n % 2 == 0;
        Predicate<String>  isLong    = s -> s.length() > 5;

        System.out.println(isEven.test(4));         // true
        System.out.println(isEven.test(7));         // false
        System.out.println(isLong.test("Hello"));   // false
        System.out.println(isLong.test("Java 8 Rocks")); // true

        // Predicate chaining
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> both = isEven.and(isPositive);
        System.out.println(both.test(4));   // true
        System.out.println(both.test(-4));  // false

        // Function<T, R> → takes T, returns R
        Function<String, Integer> strLen  = s -> s.length();
        Function<Integer, String> intToStr = n -> "Number: " + n;

        System.out.println(strLen.apply("Hello"));     // 5
        System.out.println(intToStr.apply(42));        // Number: 42

        // Function chaining
        Function<String, String> upper = s -> s.toUpperCase();
        Function<String, String> trim  = s -> s.trim();
        Function<String, String> both2 = trim.andThen(upper);
        System.out.println(both2.apply("  hello  ")); // HELLO

        // Consumer<T> → takes T, returns nothing
        Consumer<String> print  = s -> System.out.println(s);
        Consumer<String> printU = s -> System.out.println(s.toUpperCase());

        print.accept("Hello Java");    // Hello Java
        printU.accept("Hello Java");   // HELLO JAVA

        // Supplier<T> → takes nothing, returns T
        Supplier<String>  greeting = () -> "Hello World!";
        Supplier<Integer> random   = () -> (int)(Math.random() * 100);

        System.out.println(greeting.get());  // Hello World!
        System.out.println(random.get());    // random number

        // BiFunction<T, U, R> → takes T and U, returns R
        BiFunction<String, Integer, String> repeat =
            (s, n) -> s.repeat(n);
        System.out.println(repeat.apply("Java ", 3));  // Java Java Java
    }
}