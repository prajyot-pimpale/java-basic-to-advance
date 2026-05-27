public class LambdaThread {
    public static void main(String[] args) {

        // Runnable with lambda
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("Lambda Thread-1: " + i);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++)
                System.out.println("Lambda Thread-2: " + i);
        });

        t1.start();
        t2.start();
    }
}