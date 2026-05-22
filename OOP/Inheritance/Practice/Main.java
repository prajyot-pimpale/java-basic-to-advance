public class Main {
    public static void main(String[] args) {

        Employee e = new Employee("Alice", 101, 50000);
        Manager  m = new Manager("Bob",   102, 70000, 15000);
        Intern   i = new Intern("Charlie", 103, 10000);

        e.display();  // ID: 101 | Name: Alice   | Salary: 50000.0
        m.display();  // ID: 102 | Name: Bob     | Salary: 85000.0
        i.display();  // ID: 103 | Name: Charlie | Salary: 10000.0
    }
}