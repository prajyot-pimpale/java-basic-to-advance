import java.util.Map;
import java.util.stream.Collectors;

public class FrequentCharacter {
    public static void main(String[] args) {
        String s = "programming";
        char maxChar = s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .get().getKey();
        System.out.println("Most frequent: " + maxChar);  
    }
}
