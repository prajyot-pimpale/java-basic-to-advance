// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
public class ThreadMethods {
   public ThreadMethods() {
   }

   public static void main(String[] var0) throws InterruptedException {
      Thread var1 = new Thread(() -> {
         for(int var0 = 1; var0 <= 5; ++var0) {
            System.out.println("Running: " + var0);

            try {
               Thread.sleep(200L);
            } catch (InterruptedException var2) {
               break;
            }
         }

      });
      var1.setName("MyWorker");
      System.out.println("Name    : " + var1.getName());
      var1.setPriority(10);
      System.out.println("Priority: " + var1.getPriority());
      var1.start();
      System.out.println("Alive: " + var1.isAlive());
      var1.join();
      System.out.println("Alive: " + var1.isAlive());
      System.out.println("Main thread: " + Thread.currentThread().getName());
   }
}
