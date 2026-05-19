public class WideningCast {
    public static void main(String[] args) {

        int i = 100;
        long l = i;       // int → long (automatic)
        double d = l;     // long → double (automatic)

        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("double: " + d);
    }
}