public class PrimitiveTypes {
    public static void main(String[] args) {

        // 1. byte → 1 byte → range: -128 to 127
        byte b = 100;
        System.out.println("byte: " + b);

        // 2. short → 2 bytes → range: -32,768 to 32,767
        short s = 32000;
        System.out.println("short: " + s);

        // 3. int → 4 bytes → range: -2,147,483,648 to 2,147,483,647
        int age = 25;
        System.out.println("int: " + age);

        // 4. long → 8 bytes → very large numbers (add L at end)
        long population = 8000000000L;
        System.out.println("long: " + population);

        // 5. float → 4 bytes → decimal (add f at end)
        float price = 99.99f;
        System.out.println("float: " + price);

        // 6. double → 8 bytes → more precise decimal
        double pi = 3.14159265358979;
        System.out.println("double: " + pi);

        // 7. char → 2 bytes → single character (use single quotes)
        char grade = 'A';
        System.out.println("char: " + grade);

        // 8. boolean → 1 bit → only true or false
        boolean isJavaFun = true;
        System.out.println("boolean: " + isJavaFun);
    }
}