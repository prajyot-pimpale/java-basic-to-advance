// Children
class CreditCard extends Payment {
    CreditCard() { super("Credit Card"); }

    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }
}