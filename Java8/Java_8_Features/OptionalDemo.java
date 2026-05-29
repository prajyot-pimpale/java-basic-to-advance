import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        // Create Optional
        Optional<String> opt1 = Optional.of("Hello");          // not null
        Optional<String> opt2 = Optional.empty();              // empty
        Optional<String> opt3 = Optional.ofNullable(null);     // may be null

        // isPresent / isEmpty
        System.out.println(opt1.isPresent());   // true
        System.out.println(opt2.isPresent());   // false
        System.out.println(opt2.isEmpty());     // true

        // get (only if present)
        System.out.println(opt1.get());         // Hello

        // orElse → default value if empty
        System.out.println(opt2.orElse("Default"));    // Default

        // orElseGet → supplier if empty
        System.out.println(opt2.orElseGet(() -> "Generated Default")); // Generated Default

        // ifPresent → action if present
        opt1.ifPresent(val -> System.out.println("Value: " + val)); // Value: Hello

        // map → transform value if present
        Optional<Integer> length = opt1.map(String::length);
        System.out.println(length.get());   // 5

        // filter
        Optional<String> filtered = opt1.filter(s -> s.startsWith("H"));
        System.out.println(filtered.isPresent());  // true
    }
}

/* Real Use of Optional

// Real use — avoid NullPointerException
static Optional<String> findUser(int id) {
    if (id == 1) return Optional.of("Alice");
    return Optional.empty();
}

Optional<String> user = findUser(1);
user.ifPresent(u -> System.out.println("Found: " + u));  // Found: Alice

String name = findUser(99).orElse("Guest");
System.out.println(name);  // Guest

*/