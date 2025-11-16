package strategies;

public class SMSNotification implements NotificationStrategy {
    @Override public void send(String userName, String message) {
        System.out.println("[SMS] to " + userName + ": " + message);
    }
}
