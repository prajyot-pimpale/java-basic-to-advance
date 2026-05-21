// Define a Class
//only main method contains class is public 
class Car {

    // Fields (attributes)
    String brand;
    String color;
    int speed;

    // Method (behavior)
    void drive() {
        System.out.println(brand + " is driving at " + speed + " km/h");
    }

    void brake() {
        System.out.println(brand + " stopped!");
    }
}

// Create Objects
// only one public class is valid where main method is written.
public class ClassDemo{
    public static void main(String[] args) {

        // Create object using new keyword
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.color = "Red";
        car1.speed = 120;
        car1.drive();   // Toyota is driving at 120 km/h

        Car car2 = new Car();
        car2.brand = "Honda";
        car2.color = "Blue";
        car2.speed = 100;
        car2.drive();   // Honda is driving at 100 km/h
        car2.brake();   // Honda stopped!
    }
}