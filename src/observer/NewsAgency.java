package observer;

import models.News;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private final List<Subscriber> subscribers = new ArrayList<>();
    public void register(Subscriber s) {
        if (!subscribers.contains(s)) subscribers.add(s);
    }
    public void unregister(Subscriber s) {
        subscribers.remove(s);
    }
    public void publish(News news) {
        for (Subscriber s : new ArrayList<>(subscribers)) s.update(news);
    }
    public int count() {
        return subscribers.size();
    }
}
