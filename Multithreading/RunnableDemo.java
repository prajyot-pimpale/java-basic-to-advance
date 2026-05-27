class MyTask implements Runnable {

    String taskName;

    MyTask(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " step " + i +
                               " [" + Thread.currentThread().getName() + "]");
            try { 
                Thread.sleep(300); 
            }
            catch (InterruptedException e) { 
                e.printStackTrace(); 
            }
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        MyTask task1 = new MyTask("Download");
        MyTask task2 = new MyTask("Upload");
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
/*
    Runnable preferred over Thread because:
        → Java supports single inheritance
        → Runnable allows class to extend another class too
        → Better separation of task from thread management
*/