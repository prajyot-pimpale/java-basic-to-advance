public class Overloading {
    public static void main(String[] args) {

        System.out.println(add(2, 3));           // 5
        System.out.println(add(2, 3, 4));        // 9
        System.out.println(add(2.5, 3.5));       // 6.0
        System.out.println(add("Hello", " World")); // Hello World
    }

    // int + int
    static int add(int a, int b) {
        return a + b;
    }

    // int + int + int
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // double + double
    static double add(double a, double b) {
        return a + b;
    }

    // String + String
    static String add(String a, String b) {
        return a + b;
    }
}

/*

Overloading rules — must differ in:
  → Number of parameters     add(a,b) vs add(a,b,c)
  → Type of parameters       add(int,int) vs add(double,double)
  → Order of parameters      add(int,String) vs add(String,int)

Return type alone is NOT enough to overload

*/