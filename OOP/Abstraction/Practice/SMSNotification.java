class SMSNotification implements Notification {
    String phone;
    SMSNotification(String phone) { this.phone = phone; }

    @Override
    public void send(String message) {
        System.out.println("SMS to " + phone + ": " + message);
        log(message);
    }

    @Override
    public void schedule(String time) {
        System.out.println("SMS scheduled at: " + time);
    }
}
