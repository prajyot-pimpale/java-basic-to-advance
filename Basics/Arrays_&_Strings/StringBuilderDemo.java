public class StringBuilderDemo {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");

        // append
        sb.append(" World");
        System.out.println(sb);         // Hello World

        // insert
        sb.insert(5, ",");
        System.out.println(sb);         // Hello, World

        // replace
        sb.replace(7, 12, "Java");
        System.out.println(sb);         // Hello, Java

        // delete
        sb.delete(5, 6);
        System.out.println(sb);         // Hello Java

        // reverse
        sb.reverse();
        System.out.println(sb);         // avaJ olleH

        // length and charAt
        System.out.println(sb.length()); // 10
    }
}

/*

String        → immutable, new object on every change
StringBuilder → mutable, modifies same object (faster, not thread-safe)
StringBuffer  → mutable, thread-safe (slower)

*/