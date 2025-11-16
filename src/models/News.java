package models;

import observer.NewsCategory;

public abstract class News {
    private int id;
    private final String title;
    private final String text;
    private final NewsCategory category;

    public News(String title, String text, NewsCategory category) {
        this.title = title;
        this.text = text;
        this.category = category;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public String getText() { return text; }
    public NewsCategory getCategory() { return category; }
}
