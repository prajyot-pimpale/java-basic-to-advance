public class SortedDemo{
    public static void main(String[] args) {
        
        List<Integer> nums  = Arrays.asList(5, 2, 8, 1, 9, 3);
        List<String>  names = Arrays.asList("Charlie", "Alice", "Bob");

        // Natural sort (ascending)
        List<Integer> sorted = nums.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println(sorted);  // [1, 2, 3, 5, 8, 9]

        // Reverse sort (descending)
        List<Integer> desc = nums.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
        System.out.println(desc);  // [9, 8, 5, 3, 2, 1]

        // Sort strings
        List<String> sortedNames = names.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println(sortedNames);  // [Alice, Bob, Charlie]

        // Sort by length
        List<String> byLen = names.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
        System.out.println(byLen);  // [Bob, Alice, Charlie]
    }
}