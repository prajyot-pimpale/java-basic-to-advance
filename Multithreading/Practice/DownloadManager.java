public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        Thread d1 = new Thread(new Downloader("video.mp4",   500));
        Thread d2 = new Thread(new Downloader("music.mp3",   50));
        Thread d3 = new Thread(new Downloader("document.pdf", 10));

        d1.setName("Downloader-1");
        d2.setName("Downloader-2");
        d3.setName("Downloader-3");

        long start = System.currentTimeMillis();

        d1.start(); 
        d2.start(); 
        d3.start();

        d1.join(); 
        d2.join(); 
        d3.join();   // wait for all to finish

        long end = System.currentTimeMillis();
        System.out.println("All downloads done in " + (end - start) + "ms");
    }
}