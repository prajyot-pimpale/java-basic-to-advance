interface Vehicle {
    // Abstract
    void start();

    // Default method → has body
    default void info() {
        System.out.println("This is a vehicle");
    }

    // Static method → called via interface name
    static void category() {
        System.out.println("Category: Transport");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started"); 
    }
    // info() can be used as-is or overridden
}

public class DefaultAndStaticInInterface {
    Car car = new Car();
    car.start();     // Car started
    car.info();      // This is a vehicle
    Vehicle.category(); // Category: Transport
}
