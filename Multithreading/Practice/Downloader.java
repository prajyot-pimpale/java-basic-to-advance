class Downloader implements Runnable {

    String fileName;
    int    fileSize;

    Downloader(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + fileName);
        try {
            for (int i = 10; i <= 100; i += 10) {
                Thread.sleep(1000);
                System.out.printf("%-20s [%3d%%]%n", fileName, i);
            }
        } catch (InterruptedException e) {
            System.out.println(fileName + " interrupted");
        }
        System.out.println("Completed: " + fileName);
    }
}