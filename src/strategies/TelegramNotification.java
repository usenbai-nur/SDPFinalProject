package strategies;

public class TelegramNotification implements NotificationStrategy {
    @Override public void send(String userName, String message) {
        System.out.println("[Telegram] to " + userName + ": " + message);
    }
}
