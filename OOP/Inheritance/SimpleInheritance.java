// Parent Class
class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

// Child Class
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println(name + " is meowing");
    }
}

public class SimpleInheritance{
    public static void main(String[] args){
        Dog d = new Dog();
        d.name = "Tommy";
        d.eat();    // Tommy is eating   ← from Animal
        d.sleep();  // Tommy is sleeping ← from Animal
        d.bark();   // Tommy is barking  ← from Dog

        Cat c = new Cat();
        c.name = "Kitty";
        c.eat();    // Kitty is eating
        c.meow();   // Kitty is meowing
    }
}

/*
    1. Single       → One parent, one child
    2. Multilevel   → A → B → C (chain)
    3. Hierarchical → One parent, many children
    4. Multiple     → NOT supported with classes (use interfaces)
    5. Hybrid       → Combination (via interfaces)
*/