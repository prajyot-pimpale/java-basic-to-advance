import java.util.Arrays;

public class AnagramString {
    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("hello",  "world"));
    }
    static boolean isAnagram(String a, String b){
        char[] c1 = a.toCharArray();
        char[] c2 = b.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
