public class Employee {

    private String name;
    private double salary;

    // Getter
    public String getName()   { return name; }
    public double getSalary() { return salary; }

    // Setter
    public void setName(String name)     { this.name = name; }
    public void setSalary(double salary) {
        if (salary >= 0)
            this.salary = salary;
        else
            System.out.println("Salary cannot be negative");
    }
}

public class StaticAndInstanceBlock{
    public static void main(String[] args){
       Employee e = new Employee();
        e.setName("Alice");
        e.setSalary(50000);

        System.out.println(e.getName());    // Alice
        System.out.println(e.getSalary());  // 50000.0

        e.setSalary(-100);  // Salary cannot be negative
    }
}