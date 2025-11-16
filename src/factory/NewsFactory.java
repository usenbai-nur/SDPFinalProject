package factory;

import models.*;

public class NewsFactory {
    public News create(String type, String title, String text) {
        switch (type.toUpperCase()) {
            case "SPORT": return new SportNews(title, text);
            case "POLITICS": return new PoliticsNews(title, text);
            default: return new MainNews(title, text);
        }
    }
}
