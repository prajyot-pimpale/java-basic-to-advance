import java.util.*;
import java.util.function.*;

public class LambdaParam {

    // Method accepts lambda (Predicate)
    static List<Integer> filterList(List<Integer> list, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int n : list) {
            if (condition.test(n)) result.add(n);
        }
        return result;
    }

    // Method accepts lambda (Function)
    static void process(String value, Function<String, String> transform) {
        System.out.println(transform.apply(value));
    }

    // Method accepts lambda (Consumer)
    static void printAll(List<String> list, Consumer<String> action) {
        list.forEach(action);
    }

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Pass different lambdas to same method
        System.out.println(filterList(nums, n -> n % 2 == 0)); // [2,4,6,8,10]
        System.out.println(filterList(nums, n -> n > 5));       // [6,7,8,9,10]
        System.out.println(filterList(nums, n -> n % 3 == 0));  // [3,6,9]

        // Transform
        process("hello", s -> s.toUpperCase());            // HELLO
        process("  java  ", s -> s.trim());                // java
        process("hello world", s -> s.replace(" ", "_")); // hello_world

        // Print with formatting
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        printAll(names, s -> System.out.println("→ " + s));
        printAll(names, s -> System.out.println(s.toUpperCase()));
    }
}