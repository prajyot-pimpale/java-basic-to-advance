public class MethodTypes {
    public static void main(String[] args) {

        greet();                        // 1. No param, No return
        printName("Alice");             // 2. With param, No return
        int val = getNumber();          // 3. No param, With return
        int sum = add(5, 3);            // 4. With param, With return

        System.out.println("val: " + val);
        System.out.println("sum: " + sum);
    }

    // 1. No parameter, No return
    static void greet() {
        System.out.println("Hello!");
    }

    // 2. With parameter, No return
    static void printName(String name) {
        System.out.println("Name: " + name);
    }

    // 3. No parameter, With return
    static int getNumber() {
        return 42;
    }

    // 4. With parameter, With return
    static int add(int a, int b) {
        return a + b;
    }
}