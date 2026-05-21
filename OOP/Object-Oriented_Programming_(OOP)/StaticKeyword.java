class Counter {

    static int count = 0;   // shared across all objects
    String name;

    Counter(String name) {
        this.name = name;
        count++;            // increments for every object
    }

    static void showCount() {
        System.out.println("Total objects: " + count);
    }
}

public class StaticKeyword{
    public static void main(){
        Counter c1 = new Counter("A");
        Counter c2 = new Counter("B");
        Counter c3 = new Counter("C");

        Counter.showCount();   // Total objects: 3
        System.out.println(Counter.count);  // 3
    }
}