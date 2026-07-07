class Singleton {
    private static Singleton instance;
    private int count = 0;

    private Singleton() {}

    static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }

    void increment() { count++; }
    int  getCount()  { return count; }
}

public class SingletonExample {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        s1.increment(); s1.increment();
        System.out.println(s2.getCount());     // 2 (same object)
        System.out.println(s1 == s2);         // true        
    }
}
