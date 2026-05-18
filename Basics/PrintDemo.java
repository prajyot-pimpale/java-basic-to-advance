public class PrintDemo {
    public static void main(String[] args) {

        System.out.println("Hello");   // prints + new line
        System.out.print("Java ");     // prints, NO new line
        System.out.print("World");     // continues on same line
        System.out.println();          // just a blank new line

        // Output:
        // Hello
        // Java World

        // Printing numbers
        System.out.println(100);
        System.out.println(3.14);
        System.out.println(true);

        // Printing with + (concatenation)
        String name = "Alice";
        int age = 25;
        System.out.println("Name: " + name + ", Age: " + age);
        // Output: Name: Alice, Age: 25

        // Formatted print (like printf in C)
        System.out.printf("Name: %s, Age: %d, Price: %.2f%n", "Bob", 30, 99.99);
        // Output: Name: Bob, Age: 30, Price: 99.99
    }
}
/*

| Symbol | Meaning                     |
| ------ | --------------------------- |
| `%d`   | Integer                     |
| `%f`   | Float / Double              |
| `%.2f` | Float with 2 decimal places |
| `%s`   | String                      |
| `%c`   | Character                   |
| `%b`   | Boolean                     |
| `%n`   | New Line                    |

*/