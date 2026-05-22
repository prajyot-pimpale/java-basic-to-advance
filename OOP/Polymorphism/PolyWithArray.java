class Shape {
    void draw() { System.out.println("Drawing shape"); }
    double area() { return 0; }
}

class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }

    @Override
    void draw() { System.out.println("Drawing Circle"); }

    @Override
    double area() { return 3.14 * radius * radius; }
}

class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }

    @Override
    void draw() { System.out.println("Drawing Rectangle"); }

    @Override
    double area() { return l * w; }
}

class Triangle extends Shape {
    double b, h;
    Triangle(double b, double h) { this.b = b; this.h = h; }

    @Override
    void draw() { System.out.println("Drawing Triangle"); }

    @Override
    double area() { return 0.5 * b * h; }
}


public class PolyWithArray{
    public static void main(String[] args){
        // Polymorphic array
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 8)
        };

        for (Shape s : shapes) {
            s.draw();
            System.out.println("Area: " + s.area());
            System.out.println("---");
        }

        // Output:
        // Drawing Circle
        // Area: 78.5
        // ---
        // Drawing Rectangle
        // Area: 24.0
        // ---
        // Drawing Triangle
        // Area: 12.0
    }
}