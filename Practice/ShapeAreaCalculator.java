abstract class Shape{
    abstract double area(); 
}

class Circle extends Shape{
    double r; Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }
}

class Rectangle extends Shape {
    double l, w; Rectangle(double l, double w) { this.l=l; this.w=w; }
    double area() { return l * w; }
}

class Triangle  extends Shape {
    double b, h; Triangle(double b, double h) { this.b=b; this.h=h; }
    double area() { return 0.5 * b * h; }
}

public class ShapeAreaCalculator{
    public static void main(String[] args){
        // Polymorphism
        Shape[] shapes = { new Circle(5), new Rectangle(4,6), new Triangle(3,8) };
        for (Shape s : shapes)
            System.out.printf("%s area = %.2f%n", s.getClass().getSimpleName(), s.area());
    }
}
