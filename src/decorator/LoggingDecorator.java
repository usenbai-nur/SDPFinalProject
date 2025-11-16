package decorator;

import strategies.NotificationStrategy;

public class LoggingDecorator extends NotificationDecorator {
    public LoggingDecorator(NotificationStrategy wrappee) { super(wrappee); }
    @Override public void send(String userName, String message) {
        System.out.println("[LOG] " + userName + " <- " + message);
        wrappee.send(userName, message);
    }
}
