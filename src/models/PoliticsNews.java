package models;

import observer.NewsCategory;

public class PoliticsNews extends News {
    public PoliticsNews(String title, String text) { super(title, text, NewsCategory.POLITICS); }
}