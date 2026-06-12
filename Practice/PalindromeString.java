public class PalindromeString {
    public static void main(String[] args) {
        String str = "racecar";
        String rev = new StringBuffer(str).reverse().toString();
        System.out.println(str.equals(rev) ? "Palindrome" : "Not Palindrome");
    }
}
