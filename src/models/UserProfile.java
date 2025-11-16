package models;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private final String name;
    private final String email;
    private final int age;
    private boolean subscribed = false;
    private final List<Integer> bookmarks = new ArrayList<>();
    private final List<Integer> history = new ArrayList<>();
    private String signature = "";
    private String link = "";

    public UserProfile(String name, String email, int age) { this.name = name; this.email = email; this.age = age; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean s) { this.subscribed = s; }

    public void addBookmark(int id) { if (!bookmarks.contains(id)) bookmarks.add(id); }
    public List<Integer> getBookmarks() { return new ArrayList<>(bookmarks); }

    public void addHistory(int id) { history.add(0, id); if (history.size() > 200) history.remove(history.size()-1); }
    public List<Integer> getHistory() { return new ArrayList<>(history); }

    public void setSignature(String s) { this.signature = s; }
    public String getSignature() { return signature; }
    public void setLink(String l) { this.link = l; }
    public String getLink() { return link; }
}
