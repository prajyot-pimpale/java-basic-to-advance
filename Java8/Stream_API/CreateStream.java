import java.util.*;
import java.util.stream.*;

public class CreateStream {
    public static void main(String[] args) {

        // From List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> s1 = names.stream();

        // From Array
        String[] arr = {"Java", "Python", "C++"};
        Stream<String> s2 = Arrays.stream(arr);

        // From values directly
        Stream<Integer> s3 = Stream.of(1, 2, 3, 4, 5);

        // Infinite stream (limited)
        Stream<Integer> s4 = Stream.iterate(0, n -> n + 2).limit(5);
        s4.forEach(System.out::println);  // 0 2 4 6 8

        // Generate
        Stream<Double> s5 = Stream.generate(Math::random).limit(3);
        s5.forEach(System.out::println);
    }
}