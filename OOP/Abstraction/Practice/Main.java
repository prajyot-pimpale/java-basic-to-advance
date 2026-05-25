public class Main {
    public static void main(String[] args) {

        Notification[] notifications = {
            new EmailNotification("alice@mail.com"),
            new SMSNotification("+91-9999999999")
        };

        for (Notification n : notifications) {
            n.send("Your OTP is 1234");
            System.out.println("---");
        }
    }
}

// Output:
// Email to alice@mail.com: Your OTP is 1234
// [LOG] Message sent: Your OTP is 1234
// ---
// SMS to +91-9999999999: Your OTP is 1234
// [LOG] Message sent: Your OTP is 1234
