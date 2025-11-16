package observer;

import data.UserStorage;
import models.UserProfile;
import strategies.NotificationStrategy;
import strategies.StrategyFactory;
import java.util.Optional;

public class UserManager {
    private final UserStorage storage;
    private final NewsAgency agency;

    public UserManager(UserStorage storage, NewsAgency agency) {
        this.storage = storage;
        this.agency = agency;
    }

    public UserSubscriber register(String name, String email, int age, String strategyCode) {
        NotificationStrategy s = StrategyFactory.create(strategyCode);
        UserProfile p = new UserProfile(name, email, age);
        UserSubscriber us = new UserSubscriber(p, s);
        storage.addUser(us);
        return us;
    }

    public Optional<UserSubscriber> findByName(String name) {
        return storage.findByName(name);
    }
    public void subscribe(UserSubscriber u) {
        u.getProfile().setSubscribed(true);
        agency.register(u);
    }
    public void unsubscribe(UserSubscriber u) {
        u.getProfile().setSubscribed(false);
        agency.unregister(u);
    }
}
