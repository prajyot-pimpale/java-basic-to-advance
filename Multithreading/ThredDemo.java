class MyThread extends Thread{
    String name;
    
    MyThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=0; i<5 ; i++){
            System.out.println(name + " -> "+ i);
            try{
                Thread.sleep(500); // pause 500ms
            }catch(InterruptedException e){
                System.out.println(name + " interrupted");
            }
        }
    }
}

public class ThredDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-A");
        MyThread t2 = new MyThread("Thread-B");
        t1.start();  // starts thread (calls run() internally)
        t2.start();  // starts thread

        // Output (interleaved — order not guaranteed):
        // Thread-A → 1
        // Thread-B → 1
        // Thread-A → 2
        // Thread-B → 2 ...
    }
}

/*
    t1.run()   → runs in SAME thread (NOT multithreading) ❌
    t1.start() → creates NEW thread, calls run() in it    ✅
*/
