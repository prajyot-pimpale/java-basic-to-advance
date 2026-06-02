
public class ArmstrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int dup = num;
        int digits = String.valueOf(num).length();
        int sum = 0;
        while(dup != 0){
            int temp = dup % 10;
            sum += Math.pow(temp, digits); 
            dup /= 10;
        }
        System.out.println(num == sum ? "Number is Armstrong." : "Number is Not Armstrong.");
    }
}
