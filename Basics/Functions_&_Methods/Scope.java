public class Scope {

    static int globalVar = 100;  // class level (accessible everywhere)

    public static void main(String[] args) {

        int localVar = 10;  // only inside main

        System.out.println(globalVar);  // 100 ✅
        System.out.println(localVar);   // 10  ✅

        show();
    }

    static void show() {
        System.out.println(globalVar);  // 100 ✅
        // System.out.println(localVar); ← ERROR ❌ not accessible here
    }
}
/*
    Scope Rules:
    Local variable    → only inside the method/block it's declared
    Class variable    → accessible in all methods of the class
    Block variable    → only inside { } block
*/