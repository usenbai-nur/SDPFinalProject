package adapter;

import factory.NewsFactory;
import models.News;

public class ExternalNewsAdapter {
    private final NewsFactory factory;
    public ExternalNewsAdapter(NewsFactory factory) { this.factory = factory; }
    public News adapt(ExternalNews ext) {
        String type = switch (ext.getKind().toUpperCase()) {
            case "SPORTS" -> "SPORT";
            case "POLITICAL" -> "POLITICS";
            default -> "MAIN";
        };
        return factory.create(type, ext.getHeading(), ext.getBody());
    }
}
