public class StringDemo {
    public static void main(String[] args) {

        // String uses double quotes
        String name = "Alice";
        String city = "Mumbai";

        // Concatenation using +
        System.out.println("Hello, " + name);
        System.out.println(name + " lives in " + city);

        // String with numbers
        int age = 25;
        System.out.println(name + " is " + age + " years old");

        // String length
        System.out.println("Length: " + name.length());  // 5

        // Important: String is immutable (can't be changed once created)
    }
}