class NetBanking extends Payment {
    NetBanking() { super("Net Banking"); }

    @Override
    void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Net Banking");
    }
}