package ru.egor.webClinic.servlets.store;

import ru.egor.clinic.se.User;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class UserCache {
    private static final UserCache INSTANCE = new UserCache();
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    public static UserCache getINSTANCE() {
        return INSTANCE;
    }

    public Collection<User> values(){
        return this.users.values();
    }

    public void add(final User user){
        this.users.put(user.getId(), user);
    }

    public void edit(final User user){
        this.users.replace(user.getId(), user);
    }

    public void delete(final int id){
        this.users.remove(id);
    }

    public User get(final int id){
        return this.users.get(id);
    }
}
