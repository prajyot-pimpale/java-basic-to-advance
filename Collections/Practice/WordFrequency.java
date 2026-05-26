import java.util.HashMap;

public class WordFrequency {
    public static void main(String[] args) {

        String sentence = "apple mango apple banana mango apple";
        String[] words  = sentence.split(" ");

        HashMap<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (var entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
        // apple  → 3
        // mango  → 2
        // banana → 1
    }
}