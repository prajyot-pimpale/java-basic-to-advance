//only main method contains class is public 
class Student {

    String name;
    int age;
    double marks;

    // Default Constructor (no parameters)
    Student() {
        name = "Unknown";
        age  = 0;
        marks = 0.0;
    }

    // Parameterized Constructor
    Student(String name, int age, double marks) {
        this.name  = name;    // this → refers to current object
        this.age   = age;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Marks: " + marks);
    }
}

public class ConstructorDemo{
    public static void main(String[] args){
        Student s1 = new Student();                     // default constructor
        Student s2 = new Student("Alice", 20, 95.5);    // parameterized
        Student s3 = new Student("Bob", 22, 88.0);

        s1.display();  // Name: Unknown, Age: 0, Marks: 0.0
        s2.display();  // Name: Alice, Age: 20, Marks: 95.5
        s3.display();  // Name: Bob, Age: 22, Marks: 88.0
    }
}