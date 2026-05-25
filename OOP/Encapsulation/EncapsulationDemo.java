class Person {

    // Private fields → hidden from outside
    private String name;
    private int    age;
    private double salary;

    // Public Getter → read field value
    public String getName(){ return name; }
    public int    getAge()    { return age; }
    public double getSalary() { return salary; }

    // Public Setter → write field value with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
        else
            System.out.println("Name cannot be empty");
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150)
            this.age = age;
        else
            System.out.println("Invalid age: " + age);
    }

    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
        else
            System.out.println("Salary cannot be negative");
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {

        Person p = new Person();

        p.setName("Alice");
        p.setAge(25);
        p.setSalary(50000);

        System.out.println("Name  : " + p.getName());    // Alice
        System.out.println("Age   : " + p.getAge());     // 25
        System.out.println("Salary: " + p.getSalary());  // 50000.0

        // Invalid inputs
        p.setAge(-5);       // Invalid age: -5
        p.setSalary(-1000); // Salary cannot be negative
        p.setName("");      // Name cannot be empty
    }
}