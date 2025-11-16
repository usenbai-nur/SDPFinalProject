package decorator;

import models.News;

public abstract class NewsDecorator extends News {
    protected final News wrappee;
    public NewsDecorator(News wrappee) { super(wrappee.getTitle(), wrappee.getText(), wrappee.getCategory()); this.wrappee = wrappee; }
}
