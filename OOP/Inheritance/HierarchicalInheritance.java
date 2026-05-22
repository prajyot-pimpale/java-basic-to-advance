// One parent → Many children
class Shape {
    void draw() { System.out.println("Drawing a shape"); }
}

class Circle extends Shape {
    void area(double r) {
        System.out.println("Circle area: " + (3.14 * r * r));
    }
}

class Rectangle extends Shape {
    void area(double l, double w) {
        System.out.println("Rectangle area: " + (l * w));
    }
}

class Triangle extends Shape {
    void area(double b, double h) {
        System.out.println("Triangle area: " + (0.5 * b * h));
    }
}


public class HierarchicalInheritance{
    public static void main(String[] args){
        Circle    c = new Circle();
        Rectangle r = new Rectangle();
        Triangle  t = new Triangle();

        c.draw();  c.area(5);         // Drawing a shape | Circle area: 78.5
        r.draw();  r.area(4, 6);      // Drawing a shape | Rectangle area: 24.0
        t.draw();  t.area(3, 8);      // Drawing a shape | Triangle area: 12.0
    }
}

/*
    1. Single       → One parent, one child
    2. Multilevel   → A → B → C (chain)
    3. Hierarchical → One parent, many children
    4. Multiple     → NOT supported with classes (use interfaces)
    5. Hybrid       → Combination (via interfaces)
*/