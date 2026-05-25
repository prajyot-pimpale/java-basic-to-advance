interface Shape {
    double area();
}

interface Shape3D extends Shape {
    double volume();   // adds to parent interface
}

class Cube implements Shape3D {
    double side;
    Cube(double s) { this.side = s; }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}

public class InterfaceExtendInterface{
    public static void main(String[] args){
        Cube cube = new Cube(3);
        System.out.println("Area  : " + cube.area());    // 54.0
        System.out.println("Volume: " + cube.volume());  // 27.0
    }
}
