public class ChainPredicates {
    public static void main(String[] args) {

        Predicate<String> notEmpty  = s -> !s.isEmpty();
        Predicate<String> hasAt     = s -> s.contains("@");
        Predicate<String> hasDot    = s -> s.contains(".");
        Predicate<String> validEmail = notEmpty.and(hasAt).and(hasDot);

        System.out.println(validEmail.test("alice@mail.com"));  // true
        System.out.println(validEmail.test("invalid"));         // false
        
    }
}
