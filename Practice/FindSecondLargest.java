import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondLargest {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(12, 35, 1, 10, 34, 1);
        
        int second = nums.stream()
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst()
            .get();
        
            System.out.println("Second Largest: " + second);  // 34
    }
}
