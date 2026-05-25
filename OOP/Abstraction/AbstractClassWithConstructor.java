abstract class Person {

    String name;
    int age;

    // Abstract class CAN have constructor
    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    abstract void work();

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Engineer extends Person {

    String field;

    Engineer(String name, int age, String field) {
        super(name, age);    // call abstract class constructor
        this.field = field;
    }

    @Override
    void work() {
        System.out.println(name + " works as " + field + " Engineer");
    }
}

class Doctor extends Person {

    String speciality;

    Doctor(String name, int age, String speciality) {
        super(name, age);
        this.speciality = speciality;
    }

    @Override
    void work() {
        System.out.println(name + " is a " + speciality + " Doctor");
    }
}



public class AbstractClassWithConstructor{
    public static void main(String[] args){
        Engineer e = new Engineer("Alice", 28, "Software");
        Doctor   d = new Doctor("Bob", 35, "Cardiologist");

        e.display(); 
        // Name: Alice, Age: 28
        e.work();
        // Alice works as Software Engineer

        d.display(); 
        // Name: Bob, Age: 35
        d.work();
        // Bob is a Cardiologist Doctor
    }
}