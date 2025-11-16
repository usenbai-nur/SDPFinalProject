package decorator;

import models.News;

public class AnalyticsDecorator extends NewsDecorator {
    private int views = 0;
    public AnalyticsDecorator(News wrappee) { super(wrappee); }
    public void view() { views++; }
    public int getViews() { return views; }
}
