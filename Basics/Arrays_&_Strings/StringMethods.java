public class StringMethods {
    public static void main(String[] args) {

        String s = "Hello World";

        // Length
        System.out.println(s.length());           // 11

        // Case
        System.out.println(s.toUpperCase());      // HELLO WORLD
        System.out.println(s.toLowerCase());      // hello world

        // Trim whitespace
        String padded = "  Java  ";
        System.out.println(padded.trim());        // Java

        // charAt
        System.out.println(s.charAt(0));          // H
        System.out.println(s.charAt(6));          // W

        // indexOf
        System.out.println(s.indexOf("World"));   // 6
        System.out.println(s.indexOf("z"));       // -1 (not found)

        // substring
        System.out.println(s.substring(6));       // World
        System.out.println(s.substring(0, 5));    // Hello

        // replace
        System.out.println(s.replace("World", "Java")); // Hello Java

        // contains
        System.out.println(s.contains("World")); // true

        // startsWith / endsWith
        System.out.println(s.startsWith("Hello")); // true
        System.out.println(s.endsWith("World"));   // true

        // split
        String csv = "apple,mango,banana";
        String[] fruits = csv.split(",");
        for (String f : fruits)
            System.out.println(f);  // apple  mango  banana

        // equals vs ==
        String a = "hello";
        String b = "hello";
        System.out.println(a.equals(b));    // true  ✅ use this
        System.out.println(a == b);         // true (same pool, but unreliable)

        String c = new String("hello");
        System.out.println(a.equals(c));    // true  ✅
        System.out.println(a == c);         // false ❌ different objects
    }
}
/*

String        → immutable, new object on every change
StringBuilder → mutable, modifies same object (faster, not thread-safe)
StringBuffer  → mutable, thread-safe (slower)

*/

/*
+-------------------+----------------------+------------------------------+--------------+
| Method            | Description          | Example                      | Output       |
+-------------------+----------------------+------------------------------+--------------+
| length()          | Length of string     | "Java".length()              | 4            |
| charAt(i)         | Char at index        | "Java".charAt(1)             | a            |
| indexOf(s)        | First position       | "Java".indexOf("a")          | 1            |
| substring(i)      | From index to end    | "Java".substring(2)          | va           |
| substring(i,j)    | From i to j          | "Java".substring(0,2)        | Ja           |
| toUpperCase()     | All caps             | "java".toUpperCase()         | JAVA         |
| toLowerCase()     | All lower            | "JAVA".toLowerCase()         | java         |
| trim()            | Remove spaces        | " hi ".trim()                | hi           |
| replace(a,b)      | Replace text         | "cat".replace("c","b")       | bat          |
| contains(s)       | Check if exists      | "Java".contains("av")        | true         |
| equals(s)         | Compare value        | "a".equals("a")              | true         |
| split(s)          | Split into array     | "a,b".split(",")             | [a, b]       |
| isEmpty()         | Check if empty       | "".isEmpty()                 | true         |
+-------------------+----------------------+------------------------------+--------------+
*/

