package data;

import models.News;

import java.util.ArrayList;
import java.util.List;

public class NewsStorage {
    private final List<News> list = new ArrayList<>();
    private int nextId = 1;

    public void add(News n) {
        n.setId(nextId++);
        list.add(n);
    }

    public List<News> getAll() { return new ArrayList<>(list); }

    public News find(int id) { return list.stream().filter(x -> x.getId() == id).findFirst().orElse(null); }

    public List<News> getByCategory(String cat) {
        List<News> res = new ArrayList<>();
        for (News n : list) if (n.getCategory().name().equalsIgnoreCase(cat)) res.add(n);
        return res;
    }

    public int count() { return list.size(); }
}
