public class Student {

    private String name;
    private int    rollNo;
    private double marks;

    // Constructor
    public Student(String name, int rollNo, double marks) {
        setName(name);
        setRollNo(rollNo);
        setMarks(marks);
    }

    // Getters
    public String getName()   { return name; }
    public int    getRollNo() { return rollNo; }
    public double getMarks()  { return marks; }

    // Setters with validation
    public void setName(String name) {
        this.name = (name != null && !name.isEmpty()) ? name : "Unknown";
    }

    public void setRollNo(int rollNo) {
        this.rollNo = (rollNo > 0) ? rollNo : 0;
    }

    public void setMarks(double marks) {
        this.marks = (marks >= 0 && marks <= 100) ? marks : 0;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    public void display() {
        System.out.println("Roll: " + rollNo + " | Name: " + name +
                           " | Marks: " + marks + " | Grade: " + getGrade());
    }
}


public class EncapsulatinWithConstructor {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 101, 92.5);
        Student s2 = new Student("Bob",   102, 73.0);
        Student s3 = new Student("",      -1, 150);   // all invalid → defaults

        s1.display();  // Roll: 101 | Name: Alice | Marks: 92.5 | Grade: A
        s2.display();  // Roll: 102 | Name: Bob   | Marks: 73.0 | Grade: C
        s3.display();  // Roll: 0   | Name: Unknown | Marks: 0.0 | Grade: F
    }
}