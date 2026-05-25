public class Vehicle {

    private String brand;
    private int    year;
    private double price;

    public Vehicle(String brand, int year, double price) {
        this.brand = brand;
        this.year  = year;
        this.price = price;
    }

    public String getBrand() { return brand; }
    public int    getYear()  { return year; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public void display() {
        System.out.println(brand + " (" + year + ") - ₹" + price);
    }
}