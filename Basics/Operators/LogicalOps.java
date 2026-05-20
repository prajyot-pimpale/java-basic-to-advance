public class LogicalOps {
    public static void main(String[] args) {

        int age = 20;
        boolean hasID = true;

        // AND → both conditions must be true
        System.out.println(age >= 18 && hasID);    // true
        System.out.println(age >= 18 && !hasID);   // false

        // OR → at least one condition must be true
        System.out.println(age >= 18 || hasID);    // true
        System.out.println(age < 18  || hasID);    // true
        System.out.println(age < 18  || !hasID);   // false

        // NOT → reverses the condition
        System.out.println(!hasID);                // false
        System.out.println(!(age > 18));           // false

        // Real example: login check
        String user = "admin";
        String pass = "1234";
        boolean validUser = user.equals("admin");
        boolean validPass = pass.equals("1234");

        System.out.println("Login: " + (validUser && validPass)); // true
    }
}