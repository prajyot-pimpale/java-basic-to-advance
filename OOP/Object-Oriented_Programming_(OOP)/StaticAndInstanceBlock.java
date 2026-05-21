class Demo {

    static int x;
    int y;

    // Static block → runs ONCE when class loads
    static {
        x = 100;
        System.out.println("Static block: x = " + x);
    }

    // Instance block → runs every time object is created
    {
        y = 200;
        System.out.println("Instance block: y = " + y);
    }

    Demo() {
        System.out.println("Constructor called");
    }
}


public class StaticAndInstanceBlock{
    public static void main(String[] args){
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        // Output:
        // Static block: x = 100        ← only once
        // Instance block: y = 200      ← for d1
        // Constructor called
        // Instance block: y = 200      ← for d2
        // Constructor called
    }
}