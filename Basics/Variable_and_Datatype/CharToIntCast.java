public class CharToIntCast {
    public static void main(String[] args) {
        char c = 'A';
        int ascii1 = c;             // char → int (gives ASCII value)
        char d = 'a';
        int ascii2 = d;
        System.out.println(ascii1+" :- A"); // 65
        System.out.println(ascii2+" :- a"); // 97

        int num = 66;
        char ch = (char) num;      // int → char
        int num1 = 98;
        char ch1 = (char) num1;      
        System.out.println(ch);    // B
        System.out.println(ch1);    // b
    }
}