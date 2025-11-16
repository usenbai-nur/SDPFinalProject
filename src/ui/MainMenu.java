package ui;

import facade.PortalFacade;

import java.util.Scanner;

public class MainMenu {
    private final PortalFacade portal;
    private final Scanner scanner = new Scanner(System.in);

    public MainMenu(PortalFacade portal) {
        this.portal = portal;
    }

    public void run() {
        while (true) {
            System.out.println("\n=== NEWS PORTAL ===");
            System.out.println("1. Account");
            System.out.println("2. Browse");
            System.out.println("3. Admin");
            System.out.println("4. Import external");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String c = scanner.nextLine().trim();
            switch (c) {
                case "1": new CommandHandler(portal).handleAccountMenu(); break;
                case "2": new CommandHandler(portal).handleBrowseMenu(); break;
                case "3": new CommandHandler(portal).handleAdminMenu(); break;
                case "4": new CommandHandler(portal).handleImport(); break;
                case "0": return;
                default: System.out.println("Unknown"); break;
            }
        }
    }
}
