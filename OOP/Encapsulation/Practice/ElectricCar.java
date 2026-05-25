public class ElectricCar extends Vehicle {

    private int batteryCapacity;
    private int range;

    public ElectricCar(String brand, int year, double price, int battery, int range) {
        super(brand, year, price);
        this.batteryCapacity = battery;
        this.range           = range;
    }

    public int getBattery() { return batteryCapacity; }
    public int getRange()   { return range; }

    @Override
    public void display() {
        super.display();
        System.out.println("Battery: " + batteryCapacity + "kWh | Range: " + range + "km");
    }
}