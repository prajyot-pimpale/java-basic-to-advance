class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}

class Cow extends Animal {
    @Override
    void sound() { System.out.println("Cow moos"); }
}
public class RunTimePoly{
    public static void main(String[] args){
        // Upcasting → parent reference, child object
        Animal a1 = new Dog();   // Animal ref → Dog object
        Animal a2 = new Cat();   // Animal ref → Cat object
        Animal a3 = new Cow();   // Animal ref → Cow object

        a1.sound();  // Dog barks  ← decided at RUNTIME
        a2.sound();  // Cat meows
        a3.sound();  // Cow moos
    }
}