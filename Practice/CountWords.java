public class CountWords {
    public static void main(String[] args) {
        String str = "Java is a great language";
        String[] arr = str.split("\\s+");
        System.out.println(arr.length);
    }
}
