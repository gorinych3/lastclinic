package ru.egor.pojo;

public class User {

    private int id;
    private final String login;
    private final String password;

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
