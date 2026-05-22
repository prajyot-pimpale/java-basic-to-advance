// Parent
class Payment {
    String name;

    Payment(String name) {
        this.name = name;
    }

    void pay(double amount) {
        System.out.println("Paying ₹" + amount);
    }
}