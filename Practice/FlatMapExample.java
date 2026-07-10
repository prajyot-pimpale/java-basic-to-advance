import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {

        List<List<Integer>> nested = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );
        
        List<Integer> flat = nested.stream()
                                .flatMap(List::stream)
                                .collect(Collectors.toList());
                                
        System.out.println(flat);  // [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
