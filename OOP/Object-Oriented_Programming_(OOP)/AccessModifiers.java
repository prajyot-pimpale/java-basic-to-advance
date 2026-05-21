//class BankAccount
public class AccessModifiers { 

    public    String ownerName;   // accessible everywhere
    private   double balance;     // only inside this class
    protected String bankName;    // this class + subclasses + same package
              int    pin;         // default → same package only

    // public method to access private field
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }
}

/*
    +------------+-------------+--------------+-----------+------------+
    | Modifier   | Same Class  | Same Package | Subclass  | Everywhere |
    +------------+-------------+--------------+-----------+------------+
    | public     | ✅          | ✅           | ✅        | ✅         |
    | protected  | ✅          | ✅           | ✅        | ❌         |
    | default    | ✅          | ✅           | ❌        | ❌         |
    | private    | ✅          | ❌           | ❌        | ❌         |
    +------------+-------------+--------------+-----------+------------+
*/