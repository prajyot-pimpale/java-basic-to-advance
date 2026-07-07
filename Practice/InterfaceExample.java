interface Printable{
    void print(); 
}
interface Saveable{
    void save();
}

class Document implements Printable, Saveable {
    String content;
    Document(String c){
        content = c; 
    }
    public void print(){
        System.out.println("Printing: " + content); 
    }
    public void save(){
        System.out.println("Saving: "   + content); 
    }
}

public class InterfaceExample{
    public static void main(String[] args) {
        Document dc = new Document("AdhardCard");
        dc.print();
        dc.save();
    }
}