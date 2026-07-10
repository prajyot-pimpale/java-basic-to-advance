class AgeException extends RuntimeException {
    AgeException(int age){
        super("Invalid age: " + age); 
    }
}

class NameException extends RuntimeException {
    NameException(){
        super("Name Should Not Be Blank"); 
    }
}

class Person{
    private String name;
    private int age;

    Person(){

    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        if(name.isEmpty()) throw new NameException();
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age) {
        if (age < 0 || age > 150) throw new AgeException(age);
        this.age = age;
    }
}

public class CustomException{
    public static void main(String[] args) {
        Person p1 = new Person();
        
        try{ 
            p1.setAge(5);
            p1.setName("");

        }catch(AgeException e){ 
            System.out.println(e.getMessage()); 
        }catch(NameException e){
            System.out.println(e.getMessage()); 
        }

    }
}

