// Parent
class Employee {
    String name;
    int    id;
    double baseSalary;

    Employee(String name, int id, double baseSalary) {
        this.name       = name;
        this.id         = id;
        this.baseSalary = baseSalary;
    }

    double calculateSalary() {
        return baseSalary;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name +
                           " | Salary: " + calculateSalary());
    }
}