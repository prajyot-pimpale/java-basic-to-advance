class Vehicle {
    int speed;

    void start() { System.out.println("Vehicle started"); }
    void stop()  { System.out.println("Vehicle stopped"); }
}

class Car extends Vehicle {
    String brand;

    void display() {
        System.out.println(brand + " speed: " + speed);
    }
}

public class SingleInheritance{
    public static void main(String[] args){
        Car c = new Car();
        c.brand = "Toyota";
        c.speed = 120;
        c.start();    // Vehicle started
        c.display();  // Toyota speed: 120
        c.stop();     // Vehicle stopped
    }
}

/*
    1. Single       → One parent, one child
    2. Multilevel   → A → B → C (chain)
    3. Hierarchical → One parent, many children
    4. Multiple     → NOT supported with classes (use interfaces)
    5. Hybrid       → Combination (via interfaces)
*/