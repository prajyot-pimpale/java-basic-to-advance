public class  OptionalChain {
    public static void main(String[] args) {

        String email = findEmail("Alice")
            .map(String::toLowerCase)
            .orElse("not found");
        System.out.println(email);  // alice@mail.com

        System.out.println(findEmail("Bob").orElse("not found")); // not found
    }
    
    static Optional<String> findEmail(String name) {
        Map<String, String> db = Map.of("Alice", "alice@mail.com");
        return Optional.ofNullable(db.get(name));
    }
}
