package strategies;

public class WhatsAppNotification implements NotificationStrategy {
    @Override public void send(String userName, String message) {
        System.out.println("[WhatsApp] to " + userName + ": " + message);
    }
}
