import java.util.*;
import java.util.function.*;

public class MethodRefDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Lambda
        names.forEach(name -> System.out.println(name));

        // Method reference → same thing, shorter
        names.forEach(System.out::println);

        // Static method reference  → ClassName::methodName
        Function<String, Integer> parse = Integer::parseInt;
        System.out.println(parse.apply("42"));  // 42

        // Instance method reference → object::methodName
        String str  = "Hello World";
        Supplier<String> upper = str::toUpperCase;
        System.out.println(upper.get());  // HELLO WORLD

        // Constructor reference → ClassName::new
        Supplier<ArrayList> listFactory = ArrayList::new;
        ArrayList<String> list = listFactory.get();
        list.add("Java 8");
        System.out.println(list);
    }
}
/*
    Types of Method References:
    Static method      → ClassName::staticMethod
    Instance method    → object::instanceMethod
    Arbitrary object   → ClassName::instanceMethod
    Constructor        → ClassName::new
*/