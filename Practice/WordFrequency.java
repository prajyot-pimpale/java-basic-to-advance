import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is great java is fun java";
        
        Map<String, Long> freq = Arrays.stream(text.split(" "))
                                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        
        
        freq.entrySet().stream()
            .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        // java: 3  is: 2  great: 1  fun: 1
    }
}
