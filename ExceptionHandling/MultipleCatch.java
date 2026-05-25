public class MultipleCatch {
    public static void main(String[] args) {

        int[]  arr  = {1, 2, 3};
        String str  = null;

        try {
            // Uncomment one at a time to test
            int x = 10 / 0;                      // ArithmeticException
            // System.out.println(arr[10]);       // ArrayIndexOutOfBoundsException
            // System.out.println(str.length());  // NullPointerException
            // int n = Integer.parseInt("abc");   // NumberFormatException

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer error");
        } catch (NumberFormatException e) {
            System.out.println("Number format error: " + e.getMessage());
        } catch (Exception e) {
            // Catch-all → must be LAST
            System.out.println("Some error: " + e.getMessage());
        }
    }
}