import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PassAndFail {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(95, 42, 88, 55, 76, 38);
        
        Map<Boolean, List<Integer>> result = marks.stream()
                                                .collect(Collectors.partitioningBy(m -> m >= 50));
                                                
        System.out.println("Pass: " + result.get(true));   // [95, 88, 76]
        System.out.println("Fail: " + result.get(false));  // [42, 55, 38]
    }
}
