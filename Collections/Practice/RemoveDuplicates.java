import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(
            Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3)
        );
        System.out.println("Before: " + list);

        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        List<Integer> result = new ArrayList<>(set);

        System.out.println("After : " + result);
        // Before: [1, 2, 3, 2, 4, 1, 5, 3]
        // After : [1, 2, 3, 4, 5]
    }
}