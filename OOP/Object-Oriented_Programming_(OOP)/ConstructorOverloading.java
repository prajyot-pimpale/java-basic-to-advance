class Box {
    double length, width, height;

    // No-arg constructor
    Box() {
        length = width = height = 1;
    }

    // One param — cube
    Box(double side) {
        length = width = height = side;
    }

    // Three params
    Box(double l, double w, double h) {
        length = l;
        width  = w;
        height = h;
    }

    double volume() {
        return length * width * height;
    }
}

public class ConstructorOverloading{
    public static void main(Stirng[] args){
        Box b1 = new Box();           // 1x1x1
        Box b2 = new Box(5);          // 5x5x5
        Box b3 = new Box(2, 3, 4);    // 2x3x4

        System.out.println(b1.volume());  // 1.0
        System.out.println(b2.volume());  // 125.0
        System.out.println(b3.volume());  // 24.0
    }
}