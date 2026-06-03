public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrimeNumber(5));
    }
    static boolean isPrimeNumber(int num){
        if(num <= 2 )
            return false;
        for(int i=2; i<Math.sqrt(num) ;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
