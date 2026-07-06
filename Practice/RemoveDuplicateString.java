public class RemoveDuplicateString {
    public static void main(String[] args) {
        String s = "programming";
        String unique = s.chars()
            .distinct()
            .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append).toString();
        System.out.println(unique);  // progamin
    }
}
