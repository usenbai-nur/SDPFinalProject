import observer.*;
import data.*;
import facade.PortalFacade;
import factory.NewsFactory;
import ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        NewsStorage newsStorage = new NewsStorage();
        UserStorage userStorage = new UserStorage();
        NewsFactory newsFactory = new NewsFactory();
        DataInitializer.initialize(newsStorage, newsFactory);
        NewsAgency newsAgency = new NewsAgency();
        PortalFacade portal = new PortalFacade(newsStorage, userStorage, newsFactory, newsAgency);
        MainMenu mainMenu = new MainMenu(portal);
        mainMenu.run();
    }
}
