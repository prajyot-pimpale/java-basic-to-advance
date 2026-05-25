// Interface
interface Drawable {
    void draw();        // public abstract by default
    void resize();
}

interface Colorable {
    void fillColor(String color);
}

// Implement single interface
class Circle implements Drawable {

    double radius;

    Circle(double r) { this.radius = r; }

    @Override
    public void draw() {
        System.out.println("Drawing circle with radius: " + radius);
    }

    @Override
    public void resize() {
        System.out.println("Resizing circle");
    }
}

// Implement multiple interfaces
class Square implements Drawable, Colorable {

    double side;

    Square(double s) { this.side = s; }

    @Override
    public void draw() {
        System.out.println("Drawing square with side: " + side);
    }

    @Override
    public void resize() {
        System.out.println("Resizing square");
    }

    @Override
    public void fillColor(String color) {
        System.out.println("Square filled with: " + color);
    }
}

public class InterfaceClass{
    public static void main(String[] args){
        Circle c = new Circle(5);
        c.draw();    // Drawing circle with radius: 5.0
        c.resize();  // Resizing circle

        Square s = new Square(4);
        s.draw();             // Drawing square with side: 4.0
        s.fillColor("Red");   // Square filled with: Red
    }
}

/*
    Rules:
    - Declared with interface keyword
    - All methods are public abstract by default
    - All variables are public static final by default
    - A class implements interface using implements keyword
    - A class can implement MULTIPLE interfaces
    - Cannot create object of interface
*/