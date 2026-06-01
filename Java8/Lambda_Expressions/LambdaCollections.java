import java.util.*;
import java.util.stream.*;

public class LambdaCollections {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
            "Charlie", "Alice", "Bob", "Diana", "Eve"
        );

        // Sort by length then alphabetically
        names.sort(Comparator
            .comparingInt(String::length)
            .thenComparing(Comparator.naturalOrder()));
        System.out.println(names);  // [Bob, Eve, Alice, Diana, Charlie]

        // removeIf → remove matching elements
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        nums.removeIf(n -> n % 2 == 0);
        System.out.println(nums);  // [1, 3, 5]

        // replaceAll → transform each element
        List<String> words = new ArrayList<>(Arrays.asList("hello", "world", "java"));
        words.replaceAll(String::toUpperCase);
        System.out.println(words);  // [HELLO, WORLD, JAVA]

        // Map computeIfAbsent
        Map<String, List<String>> groups = new HashMap<>();
        String[] students = {"Alice", "Anna", "Bob", "Brian", "Charlie"};

        for (String s : students) {
            groups.computeIfAbsent(
                String.valueOf(s.charAt(0)),
                k -> new ArrayList<>()
            ).add(s);
        }
        System.out.println(groups);
        // {A=[Alice, Anna], B=[Bob, Brian], C=[Charlie]}

        // Map merge
        Map<String, Integer> scores = new HashMap<>();
        String[] attempts = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Alice"};

        for (String name : attempts) {
            scores.merge(name, 1, Integer::sum);
        }
        System.out.println(scores);
        // {Alice=3, Bob=2, Charlie=1}
    }
}