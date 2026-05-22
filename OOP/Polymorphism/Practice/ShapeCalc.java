class Shape {
    double area() { return 0; }
    void display() {
        System.out.printf("Area: %.2f%n", area());
    }
}

class Circle    extends Shape {
    double r;
    Circle(double r)           { this.r = r; }
    double area()              { return 3.14 * r * r; }
}

class Rectangle extends Shape {
    double l, w;
    Rectangle(double l, double w) { this.l = l; this.w = w; }
    double area()                  { return l * w; }
}

public class ShapeCalc {
    public static void main(String[] args) {

        Shape[] shapes = {
            new Circle(7),
            new Rectangle(5, 10),
        };

        for (Shape s : shapes) {
            s.display();
        }
        // Area: 153.86
        // Area: 50.00
    }
}