class Student {
    String name;
    int    age;
    double marks;

    Student(String name, int age, double marks) {
        this.name  = name;
        this.age   = age;
        this.marks = marks;
    }

    public String getName()  { return name; }
    public int    getAge()   { return age; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return name + "(" + marks + ")";
    }
}