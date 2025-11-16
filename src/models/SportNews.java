package models;

import observer.NewsCategory;

public class SportNews extends News {
    public SportNews(String title, String text) { super(title, text, NewsCategory.SPORT); }
}
