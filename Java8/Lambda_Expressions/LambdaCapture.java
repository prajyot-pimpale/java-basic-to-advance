public class LambdaCapture {
    public static void main(String[] args) {

        // Capture local variable (must be effectively final)
        String prefix = "Hello";
        Runnable r = () -> System.out.println(prefix + " World");
        r.run();  // Hello World

        // prefix = "Hi";  ← ERROR! Lambda captured it, can't change

        // Capture with counter workaround
        int[] count = {0};  // array trick for mutable capture
        Runnable counter = () -> {
            count[0]++;
            System.out.println("Count: " + count[0]);
        };
        counter.run();  // Count: 1
        counter.run();  // Count: 2
        counter.run();  // Count: 3

        // Instance variable capture (no restriction)
        new LambdaCapture().demo();
    }

    int instanceVar = 100;

    void demo() {
        Runnable r = () -> {
            instanceVar += 10;    // ✅ instance var can be modified
            System.out.println("Instance: " + instanceVar);
        };
        r.run();  // Instance: 110
        r.run();  // Instance: 120
    }
}