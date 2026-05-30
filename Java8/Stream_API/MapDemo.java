public class MapDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Convert to uppercase
        List<String> upper = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(upper);  // [ALICE, BOB, CHARLIE]

        // Get lengths
        List<Integer> lengths = names.stream()
            .map(String::length)
            .collect(Collectors.toList());
        System.out.println(lengths);  // [5, 3, 7]

        // Square numbers
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = nums.stream()
            .map(n -> n * n)
            .collect(Collectors.toList());
        System.out.println(squares);  // [1, 4, 9, 16, 25]

        // Extract field from objects
        List<String> emails = Arrays.asList("alice@mail.com", "bob@mail.com");
        List<String> users = emails.stream()
            .map(email -> email.split("@")[0])
            .collect(Collectors.toList());
        System.out.println(users);  // [alice, bob]
    }
}