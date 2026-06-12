public class CountVowelsAndConstant {
    public static void main(String[] args) {
        String str = "Hello World";
        long vowels = str.toLowerCase().chars()
                    .filter(c -> "aeiou".indexOf(c) >= 0).count();
        long consonants = str.toLowerCase().chars()
                    .filter(c -> c >= 'a' && c <= 'z' && "aeiou".indexOf(c) < 0).count();
        System.out.println("Vowels: " + vowels + " Consonants: " + consonants);
        // Vowels: 3 Consonants: 7
    }
}
