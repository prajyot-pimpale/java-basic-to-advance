class Animal {
    void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}

public class UpcastAndDowncast{
    public static void main(String[] args){
        // Upcasting → automatic (child → parent ref)
        Animal a = new Dog();    // ✅ automatic
        a.eat();                 // ✅ works
        // a.bark();             // ❌ ERROR — Animal ref can't see Dog method

        // Downcasting → manual (parent ref → child ref)
        Dog d = (Dog) a;         // manual cast ✅
        d.eat();                 // ✅ works
        d.bark();                // ✅ works now

        // Safe downcasting using instanceof
        if (a instanceof Dog) {
            Dog dog = (Dog) a;
            dog.bark();
        }
    }
}