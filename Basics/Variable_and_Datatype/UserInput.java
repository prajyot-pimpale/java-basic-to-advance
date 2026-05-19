import java.util.Scanner;   // import Scanner class

public class UserInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // create scanner object

        // String input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        // Integer input
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        // Double input
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        // Display
        System.out.println("--- Your Info ---");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Salary : " + salary);

        sc.close();  // always close scanner
    }
}

/*
+-------------------+----------------------------------+
| Method            | Reads                            |
+-------------------+----------------------------------+
| nextInt()         | Integer                         |
| nextDouble()      | Decimal                         |
| nextFloat()       | Float                           |
| nextLong()        | Long                            |
| next()            | One word (stops at space)       |
| nextLine()        | Full line with spaces           |
| nextBoolean()     | true / false                    |
+-------------------+----------------------------------+
*/