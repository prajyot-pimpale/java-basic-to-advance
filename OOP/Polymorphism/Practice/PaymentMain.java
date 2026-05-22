public class PaymentMain {
    public static void main(String[] args) {

        // Polymorphic references
        Payment p1 = new CreditCard();
        Payment p2 = new UPI();
        Payment p3 = new NetBanking();

        p1.pay(1000);   // Paid ₹1000.0 via Credit Card
        p2.pay(500);    // Paid ₹500.0 via UPI
        p3.pay(2500);   // Paid ₹2500.0 via Net Banking

        // Array of payments
        Payment[] payments = {new CreditCard(), new UPI(), new NetBanking()};
        for (Payment p : payments) {
            p.pay(100);
        }
    }
}