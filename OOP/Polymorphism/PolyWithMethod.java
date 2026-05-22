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

/*****************************/
class Printer {

    // One method accepts any Animal type
    void printSound(Animal a) {
        a.sound();   // calls overridden method of actual object
    }
}

public class PolyWithMethod{
    public static void main(String[] args){
        Printer p = new Printer();

        p.printSound(new Dog());  // Dog barks
        p.printSound(new Cat());  // Cat meows
        p.printSound(new Cow());  // Cow moos
    }
}