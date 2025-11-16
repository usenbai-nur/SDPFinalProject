package models.builders;

import models.UserProfile;

public class UserProfileBuilder {
    private String name = "user";
    private String email = "noreply@example.com";
    private int age = 18;
    private String signature = "";
    private String link = "";

    public UserProfileBuilder setName(String name) { this.name = name; return this; }
    public UserProfileBuilder setEmail(String email) { this.email = email; return this; }
    public UserProfileBuilder setAge(int age) { this.age = age; return this; }
    public UserProfileBuilder setSignature(String s) { this.signature = s; return this; }
    public UserProfileBuilder setLink(String l) { this.link = l; return this; }

    public UserProfile build() {
        UserProfile p = new UserProfile(name, email, age);
        p.setSignature(signature);
        p.setLink(link);
        return p;
    }
}
