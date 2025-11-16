package decorator;

import strategies.NotificationStrategy;

public abstract class NotificationDecorator implements NotificationStrategy {
    protected final NotificationStrategy wrappee;
    public NotificationDecorator(NotificationStrategy wrappee) { this.wrappee = wrappee; }
}
