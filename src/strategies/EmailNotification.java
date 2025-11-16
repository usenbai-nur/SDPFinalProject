package strategies;

public class EmailNotification implements NotificationStrategy {
    @Override public void send(String userName, String message) {
        System.out.println("[Email] to " + userName + ": " + message);
    }
}
