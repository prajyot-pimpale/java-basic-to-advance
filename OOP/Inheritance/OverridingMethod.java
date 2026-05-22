class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");    // overrides parent
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");    // overrides parent
    }
}

public class OverridingMethod{
    public static void main(String[] args){
        Animal a = new Animal();
        Dog    d = new Dog();
        Cat    c = new Cat();

        a.sound();  // Animal makes a sound
        d.sound();  // Dog barks
        c.sound();  // Cat meows
    }
}

/*
    Rules for Overriding:
    - Same method name
    - Same parameters
    - Same or wider return type
    - Cannot override private/static/final methods
    - Use @Override annotation (good practice)
*/