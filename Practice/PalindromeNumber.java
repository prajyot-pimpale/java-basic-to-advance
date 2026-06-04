public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 123321;
        int original = num;
        int reverse = 0;
        while(num != 0){
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        System.out.println(original == reverse ? "Number Is Palindrome" : "Number Is Not Palindrome");
    }
}
