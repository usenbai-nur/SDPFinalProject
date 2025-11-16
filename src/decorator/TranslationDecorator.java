package decorator;

import strategies.NotificationStrategy;

public class TranslationDecorator extends NotificationDecorator {
    private final String lang;
    public TranslationDecorator(NotificationStrategy wrappee, String lang) { super(wrappee); this.lang = lang; }
    @Override public void send(String userName, String message) {
        String translated = translate(message, lang);
        wrappee.send(userName, translated);
    }
    private String translate(String m, String lang) { if ("ru".equalsIgnoreCase(lang)) return "[RU] " + m; return m; }
}
