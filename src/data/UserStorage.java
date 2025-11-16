package data;

import observer.UserSubscriber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserStorage {
    private final List<UserSubscriber> users = new ArrayList<>();

    public void addUser(UserSubscriber u) { users.add(u); }

    public Optional<UserSubscriber> findByName(String name) {
        return users.stream().filter(x -> x.getProfile().getName().equalsIgnoreCase(name)).findFirst();
    }

    public List<UserSubscriber> getAll() { return new ArrayList<>(users); }
}
