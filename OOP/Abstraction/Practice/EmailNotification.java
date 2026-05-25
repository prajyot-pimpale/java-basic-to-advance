// Implementations
class EmailNotification implements Notification {
    String email;
    EmailNotification(String email) { this.email = email; }

    @Override
    public void send(String message) {
        System.out.println("Email to " + email + ": " + message);
        log(message);
    }

    @Override
    public void schedule(String time) {
        System.out.println("Email scheduled at: " + time);
    }
}