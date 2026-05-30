import java.util.*;
import java.util.stream.*;

public class FilterDemo {
    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evens = nums.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("Evens: " + evens);  // [2, 4, 6, 8, 10]

        // Filter > 5
        List<Integer> big = nums.stream()
            .filter(n -> n > 5)
            .collect(Collectors.toList());
        System.out.println("Big  : " + big);    // [6, 7, 8, 9, 10]

        // Filter strings starting with A
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie", "Alex");

        List<String> aNames = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());
        System.out.println("A names: " + aNames);  // [Alice, Anna, Alex]
    }
}