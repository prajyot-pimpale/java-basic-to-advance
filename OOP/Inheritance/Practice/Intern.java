// Child 2
class Intern extends Employee {
    int stipend;

    Intern(String name, int id, int stipend) {
        super(name, id, 0);
        this.stipend = stipend;
    }

    @Override
    double calculateSalary() {
        return stipend;
    }
}