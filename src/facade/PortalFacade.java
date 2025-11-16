package facade;

import adapter.ExternalNews;
import adapter.ExternalNewsAdapter;
import observer.*;
import data.*;
import factory.NewsFactory;
import models.News;

import java.util.List;

public class PortalFacade {
    private final NewsStorage newsStorage;
    private final UserStorage userStorage;
    private final NewsFactory newsFactory;
    private final NewsAgency agency;
    private final NewsManager newsManager;
    private final UserManager userManager;

    public PortalFacade(NewsStorage ns, UserStorage us, NewsFactory nf, NewsAgency a) {
        this.newsStorage = ns;
        this.userStorage = us;
        this.newsFactory = nf;
        this.agency = a;
        this.newsManager = new NewsManager(ns, a, nf);
        this.userManager = new UserManager(us, a);
    }

    public void publishNews(String type, String title, String text) { newsManager.publish(type, title, text); }

    public List<News> listAll() { return newsManager.getAll(); }

    public News find(int id) { return newsManager.findById(id); }

    public void importExternal(ExternalNews ext) {
        ExternalNewsAdapter adapter = new ExternalNewsAdapter(newsFactory);
        News n = adapter.adapt(ext);
        newsManager.publish(n.getCategory().name(), n.getTitle(), n.getText());
    }

    public UserManager getUserManager() { return userManager; }
    public NewsManager getNewsManager() { return newsManager; }
}
