// Abstract class
abstract class Animal {

    String name;

    // Abstract method → no body, must be overridden
    abstract void sound();

    // Concrete method → has body
    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child class MUST implement abstract method
class Dog extends Animal {
    Dog(String name) { this.name = name; }

    @Override
    void sound() {
        System.out.println(name + " barks");
    }
}

class Cat extends Animal {
    Cat(String name) { this.name = name; }

    @Override
    void sound() {
        System.out.println(name + " meows");
    }
}

public class AbstractClass{
    public static void main(String[] args){
        // Animal a = new Animal(); ← ERROR ❌ cannot instantiate abstract class

        Dog d = new Dog("Tommy");
        Cat c = new Cat("Kitty");

        d.sound();  // Tommy barks
        d.eat();    // Tommy is eating
        c.sound();  // Kitty meows
        c.sleep();  // Kitty is sleeping
    }
}

/*
    Rules:
    - Declared with abstract keyword
    - Can have abstract methods (no body)
    - Can have concrete methods (with body)
    - Cannot create object of abstract class
    - Child class MUST implement all abstract methods
*/