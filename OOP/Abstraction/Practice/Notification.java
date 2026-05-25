// Interface
interface Notification {
    void send(String message);
    void schedule(String time);

    default void log(String msg) {
        System.out.println("[LOG] Message sent: " + msg);
    }
}
