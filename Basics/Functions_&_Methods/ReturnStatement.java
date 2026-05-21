public class ReturnStatement{
    public static void main(String[] args){
        // Single return
        static int square(int n) {
            return n * n;
        }

        // Multiple returns (based on condition)
        static String checkAge(int age) {
            if (age >= 18) {
                return "Adult";
            } else {
                return "Minor";
            }
        }

        // void method — no return value
        static void printSquare(int n) {
            System.out.println(n * n);
            // no return needed
        }
    }
}