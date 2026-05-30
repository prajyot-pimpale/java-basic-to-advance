public class TerminalOperations{
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6);

        // count
        long count = nums.stream().filter(n -> n > 3).count();
        System.out.println("Count > 3 : " + count);  // 4

        // sum / average (use IntStream)
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum       : " + sum);     // 31

        double avg = nums.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("Average   : " + avg);     // 3.875

        // min / max
        int max = nums.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = nums.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("Max: " + max + " Min: " + min);  // Max: 9 Min: 1

        // findFirst
        Optional<Integer> first = nums.stream().filter(n -> n > 5).findFirst();
        System.out.println("First > 5 : " + first.get());  // 9

        // anyMatch / allMatch / noneMatch
        System.out.println(nums.stream().anyMatch(n -> n > 8));   // true
        System.out.println(nums.stream().allMatch(n -> n > 0));   // true
        System.out.println(nums.stream().noneMatch(n -> n > 10)); // true

        // reduce
        int product = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);  // 6480
    }
}