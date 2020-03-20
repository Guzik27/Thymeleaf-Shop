package pl.edu.wszib.dao;

import pl.edu.wszib.domain.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers(); // zwraca listę produktów
    void saveUser(User user); // nic nie zwraca, jako parametr oczekuje produktu

    void removeUser(Long userId);

    User getById(Long userId);

    void deactivationUsers(boolean active);
}