import java.util.*;

class Employee {
    String name;
    String dept;
    double salary;

    Employee(String n, String d, double s) {
        name = n; dept = d; salary = s;
    }

    public String toString() {
        return name + "(" + dept + ", " + salary + ")";
    }
}

public class ComparitorWithLambda{
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice",   "IT",  75000),
            new Employee("Bob",     "HR",  55000),
            new Employee("Charlie", "IT",  90000),
            new Employee("Diana",   "HR",  65000),
            new Employee("Eve",     "IT",  75000)
        );

        // Sort by salary
        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));
        employees.forEach(e -> System.out.println(e));

        // Sort by department then name
        employees.sort(Comparator
            .comparing((Employee e) -> e.dept)
            .thenComparing(e -> e.name));
        employees.forEach(System.out::println);

        // Sort by salary descending
        employees.sort(Comparator.comparingDouble((Employee e) -> e.salary).reversed());
        System.out.println("\nTop earner: " + employees.get(0));
    }
}