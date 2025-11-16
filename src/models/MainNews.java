package models;

import observer.NewsCategory;

public class MainNews extends News {
    public MainNews(String title, String text) { super(title, text, NewsCategory.MAIN); }
}

