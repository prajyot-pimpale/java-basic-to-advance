import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformListWithMap {
    public static void main(String[] args) {
        List<String> names  = Arrays.asList("alice", "bob", "charlie");

        List<String> result = names.stream()
                                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                                .collect(Collectors.toList());
        
        System.out.println(result);  // [Alice, Bob, Charlie]
    }
}
