import java.util.*;

public class ForEachDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Old way
        for (String name : names)
            System.out.println(name);

        // Java 8 forEach
        names.forEach(name -> System.out.println(name));

        // Method reference
        names.forEach(System.out::println);

        // HashMap forEach
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob",   80);
        scores.put("Charlie", 75);

        scores.forEach((name, score) ->
            System.out.println(name + " → " + score));
    }
}