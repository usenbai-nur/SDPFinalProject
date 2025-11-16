package ui;

import adapter.ExternalNews;
import observer.UserSubscriber;
import decorator.LoggingDecorator;
import decorator.TranslationDecorator;
import facade.PortalFacade;
import models.News;
import strategies.NotificationStrategy;
import strategies.StrategyFactory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CommandHandler {
    private final PortalFacade portal;
    private final Scanner scanner = new Scanner(System.in);
    private static final String ADMIN_KEY = "admin123";

    public CommandHandler(PortalFacade portal) { this.portal = portal; }

    public void handleAccountMenu() {
        while (true) {
            System.out.println("\nAccount Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            switch (c) {
                case "1": register(); break;
                case "2": login(); break;
                case "0": return;
                default: System.out.println("Unknown"); break;
            }
        }
    }

    private void register() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Choose notification: 1)Email 2)SMS 3)WhatsApp 4)Telegram");
        String code = scanner.nextLine().trim();
        UserSubscriber u = portal.getUserManager().register(name, email, age, code);
        System.out.println("Registered " + name);
    }

    private void login() {
        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        Optional<UserSubscriber> opt = portal.getUserManager().findByName(name);
        if (opt.isEmpty()) { System.out.println("Not found"); return; }
        UserSubscriber user = opt.get();
        handleUserMenu(user);
    }

    private void handleUserMenu(UserSubscriber u) {
        while (true) {
            System.out.println("\nUser: " + u.getProfile().getName());
            System.out.println("1. View profile");
            System.out.println("2. Change notification");
            System.out.println("3. Subscribe/Unsubscribe");
            System.out.println("4. View feed");
            System.out.println("5. Read by id");
            System.out.println("6. Bookmark by id");
            System.out.println("7. View bookmarks");
            System.out.println("8. View history");
            System.out.println("9. View notifications log");
            System.out.println("0. Logout");
            System.out.print("Choice: ");
            String ch = scanner.nextLine().trim();
            switch (ch) {
                case "1": viewProfile(u); break;
                case "2": changeNotification(u); break;
                case "3": toggleSubscription(u); break;
                case "4": viewFeed(u); break;
                case "5": readById(u); break;
                case "6": bookmark(u); break;
                case "7": viewBookmarks(u); break;
                case "8": viewHistory(u); break;
                case "9": viewLogs(u); break;
                case "0": return;
                default: System.out.println("Unknown"); break;
            }
        }
    }

    private void viewProfile(UserSubscriber u) {
        System.out.println("Name: " + u.getProfile().getName());
        System.out.println("Email: " + u.getProfile().getEmail());
        System.out.println("Age: " + u.getProfile().getAge());
        System.out.println("Subscribed: " + (u.getProfile().isSubscribed() ? "yes" : "no"));
        System.out.println("Signature: " + u.getProfile().getSignature());
        System.out.println("Link: " + u.getProfile().getLink());
    }

    private void changeNotification(UserSubscriber u) {
        System.out.println("Choose: 1)Email 2)SMS 3)WhatsApp 4)Telegram");
        String code = scanner.nextLine().trim();
        NotificationStrategy s = StrategyFactory.create(code);
        System.out.print("Add logging? y/n: ");
        if ("y".equalsIgnoreCase(scanner.nextLine().trim())) s = new LoggingDecorator(s);
        System.out.print("Translate to RU? y/n: ");
        if ("y".equalsIgnoreCase(scanner.nextLine().trim())) s = new TranslationDecorator(s, "ru");
        u.setStrategy(s);
        System.out.println("Updated");
    }

    private void toggleSubscription(UserSubscriber u) {
        if (u.getProfile().isSubscribed()) { portal.getUserManager().unsubscribe(u); System.out.println("Unsubscribed"); }
        else { portal.getUserManager().subscribe(u); System.out.println("Subscribed"); }
    }

    private void viewFeed(UserSubscriber u) {
        List<News> all = portal.listAll();
        for (News n : all) System.out.println(n.getId() + " | [" + n.getCategory() + "] " + n.getTitle());
    }

    private void readById(UserSubscriber u) {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        News n = portal.find(id);
        if (n == null) { System.out.println("No such"); return; }
        System.out.println("=== " + n.getTitle() + " ===");
        System.out.println(n.getText());
        u.getProfile().addHistory(id);
    }

    private void bookmark(UserSubscriber u) {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine().trim());
        u.getProfile().addBookmark(id);
        System.out.println("Bookmarked");
    }

    private void viewBookmarks(UserSubscriber u) { System.out.println(u.getProfile().getBookmarks()); }
    private void viewHistory(UserSubscriber u) { System.out.println(u.getProfile().getHistory()); }
    private void viewLogs(UserSubscriber u) {
        for (String s : u.getNotificationsLog()) System.out.println("- " + s);
    }

    public void handleBrowseMenu() {
        List<News> all = portal.listAll();
        for (News n : all) System.out.println(n.getId() + " | [" + n.getCategory() + "] " + n.getTitle());
    }

    public void handleAdminMenu() {
        System.out.print("Admin key: ");
        String key = scanner.nextLine().trim();
        if (!ADMIN_KEY.equals(key)) { System.out.println("Wrong"); return; }
        System.out.print("Category (SPORT/POLITICS/MAIN): ");
        String cat = scanner.nextLine().trim();
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Text: ");
        String text = scanner.nextLine().trim();
        portal.publishNews(cat, title, text);
        System.out.println("Published");
    }

    public void handleImport() {
        ExternalNews ext = new ExternalNews("SPORTS", "Adapter import: Star scores", "A star scored a hat-trick in a friendly.");
        portal.importExternal(ext);
        System.out.println("Imported via adapter");
    }
}
