package pl.edu.wszib.domain;

import java.util.Map;

public class User {
    private long id;
    private String login;
    private String mail;
    private int age;
    private String country;
    private boolean active;



    public long getId() {
        return id;
    }

    public void setId(long user) {
        this.id = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Iterable<? extends Map.Entry> entrySet() {
        return null;
    }
}
