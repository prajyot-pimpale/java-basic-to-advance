class Calculator {
    // Same name, different parameters
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }

    String add(String a, String b) {
        return a + b;
    }
}
public class CompileTimePoly{
    public static void main(String[] args){
        Calculator calc = new Calculator();
        System.out.println(calc.add(2, 3));           // 5
        System.out.println(calc.add(2, 3, 4));        // 9
        System.out.println(calc.add(2.5, 3.5));       // 6.0
        System.out.println(calc.add("Hello", " Java")); // Hello Java
    }
}