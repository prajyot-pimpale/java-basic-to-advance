//class Person
public class ThisKeyword{

    String name;
    int age;

    // Without this → confusion between field and parameter
    Person(String name, int age) {
        this.name = name;   // this.name = field, name = parameter
        this.age  = age;
    }

    // this() → call another constructor
    Person(String name) {
        this(name, 0);      // calls Person(String, int)
    }

    // Return current object
    Person setName(String name) {
        this.name = name;
        return this;        // method chaining
    }

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
