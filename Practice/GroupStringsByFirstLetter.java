import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByFirstLetter {
    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("Alice","Anna","Bob","Brian","Charlie");

        Map<Character, List<String>> grouped = names.stream()
                                                    .collect(Collectors.groupingBy(s -> s.charAt(0)));
        
        grouped.forEach((k, v) -> System.out.println(k + ": " + v));
        // A: [Alice, Anna]  B: [Bob, Brian]  C: [Charlie]

    }
}
