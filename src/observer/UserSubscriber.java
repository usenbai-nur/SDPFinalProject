package observer;

import models.UserProfile;
import models.News;
import strategies.NotificationStrategy;
import java.util.ArrayList;
import java.util.List;

public class UserSubscriber implements Subscriber {
    private final UserProfile profile;
    private NotificationStrategy strategy;
    private final List<String> notificationsLog = new ArrayList<>();

    public UserSubscriber(UserProfile profile, NotificationStrategy strategy) {
        this.profile = profile;
        this.strategy = strategy;
    }
    public UserProfile getProfile() {
        return profile;
    }
    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }
    public NotificationStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void update(News news) {
        if (!profile.isSubscribed()) return;
        String msg = "New: " + news.getTitle() + " [" + news.getCategory() + "]";
        strategy.send(profile.getName(), msg);
        notificationsLog.add(msg);
        if (notificationsLog.size() > 200) notificationsLog.remove(0);
    }
    public List<String> getNotificationsLog() {
        return new ArrayList<>(notificationsLog);
    }
}
