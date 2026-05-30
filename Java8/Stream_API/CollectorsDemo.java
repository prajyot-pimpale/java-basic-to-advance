import java.util.stream.Collectors;

public class CollectorsDemo{
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Anna", "Brian");

        // toList
        List<String> list = names.stream().collect(Collectors.toList());

        // toSet
        Set<String> set = names.stream().collect(Collectors.toSet());

        // joining
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined);  // Alice, Bob, Charlie, Anna, Brian

        String joined2 = names.stream()
            .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(joined2);  // [Alice, Bob, Charlie, Anna, Brian]

        // groupingBy
        Map<Integer, List<String>> byLength = names.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println(byLength);
        // {3=[Bob], 4=[Anna], 5=[Alice, Brian], 7=[Charlie]}

        // counting
        Map<Integer, Long> countByLen = names.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(countByLen);  // {3=1, 4=1, 5=2, 7=1}

        // partitioningBy
        Map<Boolean, List<String>> partition = names.stream()
            .collect(Collectors.partitioningBy(s -> s.startsWith("A")));
        System.out.println("A names : " + partition.get(true));   // [Alice, Anna]
        System.out.println("Others  : " + partition.get(false));  // [Bob, Charlie, Brian]
    }
}