import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "Diana");

        // Before Java 8
        Collections.sort(names, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // Java 8 Lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Even shorter
        names.sort(String::compareTo);

        System.out.println(names);  // [Alice, Bob, Charlie, Diana]

        // Lambda with forEach
        names.forEach(name -> System.out.println("Hello, " + name));

        // Lambda with numbers
        List<Integer> nums = Arrays.asList(5, 2, 8, 1, 9, 3);
        nums.sort((a, b) -> a - b);   // ascending
        System.out.println(nums);     // [1, 2, 3, 5, 8, 9]
    }
}