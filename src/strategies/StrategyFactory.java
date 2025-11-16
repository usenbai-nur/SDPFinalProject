package strategies;

public class StrategyFactory {
    public static NotificationStrategy create(String code) {
        if ("2".equals(code)) return new SMSNotification();
        if ("3".equals(code)) return new WhatsAppNotification();
        if ("4".equals(code)) return new TelegramNotification();
        return new EmailNotification();
    }
}
