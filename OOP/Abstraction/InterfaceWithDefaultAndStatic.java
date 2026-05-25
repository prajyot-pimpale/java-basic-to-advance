interface Vehicle {

    // Abstract method
    void start();

    // Default method → has body, can be overridden
    default void fuelType() {
        System.out.println("Default fuel: Petrol");
    }

    // Static method → called using interface name
    static void info() {
        System.out.println("Vehicle Interface");
    }
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    // Override default method (optional)
    @Override
    public void fuelType() {
        System.out.println("Car fuel: Diesel");
    }
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike started");
    }
    // fuelType() not overridden → uses default
}



public class InterfaceWithDefaultAndStatic{
    public static void main(String[] args){
        Car  car  = new Car();
        Bike bike = new Bike();

        car.start();     // Car started
        car.fuelType();  // Car fuel: Diesel  ← overridden

        bike.start();    // Bike started
        bike.fuelType(); // Default fuel: Petrol  ← default used

        Vehicle.info();  // Vehicle Interface  ← static call
    }
}
