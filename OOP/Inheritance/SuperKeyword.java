class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor: " + name);
    }

    void eat() {
        System.out.println(name + " eats food");
    }
}

class Dog extends Animal {

    String breed;

    Dog(String name, String breed) {
        super(name);           // call parent constructor → MUST be first line
        this.breed = breed;
        System.out.println("Dog constructor: " + breed);
    }

    void eat() {
        super.eat();           // call parent method
        System.out.println(name + " eats dog food");
    }

    void display() {
        System.out.println("Name: " + super.name + ", Breed: " + breed);
    }
}

public class SuperKeyword{
    public static void main(String[] args){
        Dog d = new Dog("Tommy", "Labrador");
        d.eat();
        d.display();

        // Output:
        // Animal constructor: Tommy
        // Dog constructor: Labrador
        // Tommy eats food        ← super.eat()
        // Tommy eats dog food    ← Dog's own eat()
        // Name: Tommy, Breed: Labrador
    }
}