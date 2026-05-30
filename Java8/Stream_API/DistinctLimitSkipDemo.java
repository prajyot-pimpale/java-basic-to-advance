public class DistinctLimitSkipDemo{
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);

        // distinct → remove duplicates
        List<Integer> unique = nums.stream()
            .distinct()
            .collect(Collectors.toList());
        System.out.println(unique);  // [1, 2, 3, 4, 5]

        // limit → first N elements
        List<Integer> first3 = nums.stream()
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(first3);  // [1, 2, 2]

        // skip → skip first N elements
        List<Integer> skip3 = nums.stream()
            .skip(3)
            .collect(Collectors.toList());
        System.out.println(skip3);  // [3, 3, 4, 5, 5]

        // Combine
        List<Integer> page2 = nums.stream()
            .distinct()
            .skip(2)
            .limit(2)
            .collect(Collectors.toList());
        System.out.println(page2);  // [3, 4]  ← like pagination
    }
}