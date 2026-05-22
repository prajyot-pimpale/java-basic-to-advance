class UPI extends Payment {
    UPI() { super("UPI"); }

    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }
}
