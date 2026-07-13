import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortByMultipleFields {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Anna");
        
        names.sort(Comparator.comparingInt(String::length)
            .thenComparing(Comparator.naturalOrder()));
        
            System.out.println(names);  // [Bob, Anna, Alice, Charlie] 
    }
}
