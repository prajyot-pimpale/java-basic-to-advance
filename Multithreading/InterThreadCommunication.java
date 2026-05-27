class SharedBox {

    int value;
    boolean hasValue = false;

    // Producer puts value
    synchronized void produce(int val) throws InterruptedException {
        while (hasValue) wait();          // wait if box is full
        value    = val;
        hasValue = true;
        System.out.println("Produced: " + val);
        notify();                          // notify consumer
    }

    // Consumer gets value
    synchronized int consume() throws InterruptedException {
        while (!hasValue) wait();          // wait if box is empty
        hasValue = false;
        System.out.println("Consumed: " + value);
        notify();                          // notify producer
        return value;
    }
}
public class InterThreadCommunication {
    public static void main(String[] args) {

        SharedBox box = new SharedBox();
        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++)
                    box.produce(i);
            }catch(InterruptedException e){
                e.printStackTrace(); 
            }
        });
        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++)
                    box.consume();
            } catch(InterruptedException e){
                e.printStackTrace(); 
            }
        });
        producer.start();
        consumer.start();
    }
}

// Output:
// Produced: 1
// Consumed: 1
// Produced: 2
// Consumed: 2 ...