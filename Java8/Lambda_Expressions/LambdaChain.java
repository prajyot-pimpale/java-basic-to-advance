import java.util.function.*;

public class LambdaChain {
    public static void main(String[] args) {

        // Function chaining
        Function<Integer, Integer> times2 = n -> n * 2;
        Function<Integer, Integer> plus10 = n -> n + 10;
        Function<Integer, Integer> square = n -> n * n;

        // andThen → apply first, then second
        Function<Integer, Integer> times2ThenPlus10 = times2.andThen(plus10);
        System.out.println(times2ThenPlus10.apply(5));  // (5*2)+10 = 20

        // compose → apply second first, then first
        Function<Integer, Integer> plus10ThenTimes2 = times2.compose(plus10);
        System.out.println(plus10ThenTimes2.apply(5));  // (5+10)*2 = 30

        // Chain multiple
        Function<String, String> pipeline = ((Function<String,String>) String::trim)
            .andThen(String::toLowerCase)
            .andThen(s -> s.replace(" ", "_"));
        System.out.println(pipeline.apply("  Hello World  "));  // hello_world

        // Predicate chaining
        Predicate<Integer> isEven     = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isSmall    = n -> n < 100;

        Predicate<Integer> combined = isEven.and(isPositive).and(isSmall);
        System.out.println(combined.test(4));    // true
        System.out.println(combined.test(-4));   // false (not positive)
        System.out.println(combined.test(200));  // false (not small)

        // negate
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isOdd.test(3));   // true
        System.out.println(isOdd.test(4));   // false

        // or
        Predicate<String> isEmpty  = String::isEmpty;
        Predicate<String> isNull   = s -> s == null;
        Predicate<String> isBlank  = isEmpty.or(s -> s.trim().isEmpty());
        System.out.println(isBlank.test(""));      // true
        System.out.println(isBlank.test("  "));    // true
        System.out.println(isBlank.test("hello")); // false
    }
}