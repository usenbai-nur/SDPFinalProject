package observer;

import data.NewsStorage;
import factory.NewsFactory;
import models.News;
import java.util.List;

public class NewsManager {
    private final NewsStorage storage;
    private final NewsAgency agency;
    private final NewsFactory factory;

    public NewsManager(NewsStorage storage, NewsAgency agency, NewsFactory factory) {
        this.storage = storage;
        this.agency = agency;
        this.factory = factory;
    }

    public void publish(String type, String title, String text) {
        News n = factory.create(type, title, text);
        storage.add(n);
        agency.publish(n);
    }

    public List<News> getAll() { return storage.getAll(); }

    public News findById(int id) { return storage.find(id); }

    public List<News> getByCategory(String category) { return storage.getByCategory(category); }
}
