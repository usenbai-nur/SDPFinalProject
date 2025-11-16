package observer;

import models.News;

public interface Subscriber {
    void update(News news);
}
