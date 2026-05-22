// Level 1
class Animal {
    void eat() { System.out.println("Animal eats"); }
}

// Level 2
class Dog extends Animal {
    void bark() { System.out.println("Dog barks"); }
}

// Level 3
class BabyDog extends Dog {
    void weep() { System.out.println("Baby dog weeps"); }
}

public class MultilevelInheritance{
    public static void main(String[] args){
        BabyDog bd = new BabyDog();
        bd.eat();   // from Animal  ← Level 1
        bd.bark();  // from Dog     ← Level 2
        bd.weep();  // from BabyDog ← Level 3
    }
}

/*
    1. Single       → One parent, one child
    2. Multilevel   → A → B → C (chain)
    3. Hierarchical → One parent, many children
    4. Multiple     → NOT supported with classes (use interfaces)
    5. Hybrid       → Combination (via interfaces)
*/