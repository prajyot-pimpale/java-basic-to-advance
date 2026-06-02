public class SwapTwoNumbers{
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        System.out.println("Value of a: "+a+" And b:"+b);
        System.out.println();

        //  Method 01 - Using temp variable.
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Method 01");
        System.out.println("Value of a: "+a+" And b:"+b);
        System.out.println();

        //Method 02 - Using Arithmatic Operator
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("Method 02");
        System.out.println("Value of a: "+a+" And b:"+b);
        System.out.println();

        //Method 03 - Using XOR Operator
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Method 03");
        System.out.println("Value of a: "+a+" And b:"+b);
        System.out.println();
    }
}