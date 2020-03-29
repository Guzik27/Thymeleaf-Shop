package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {
    private Map<Long, User> userMap; // klucz i wartość
    private static Long id = 1L; // od tego zacznie tworzyć uzytkownikow w bazie

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(userMap.values()); // zwraca nam listę produktów
    }


    public UserDaoImpl() {
        this.userMap = new HashMap<>();
        prepareUserList(); // generuje początkowy zbiór uzytkownikow
    }


    // implementujemy metodę saveProduct
    @Override
    public void saveUser(User user) {
        if (user.getId() < 1) {
            user.setId(id);
            id++;
        }
        userMap.put(user.getId(), user); // do mapy
    }

    @Override
    public void removeUser(Long id) {
        userMap.remove(id);
    }

    @Override
    public User getById(Long id) {
        return userMap.get(id);
    }

    @Override
    public void inactiveUsers() {
        Set<Map.Entry<Long, User>> activeSet = userMap.entrySet();
        for (Map.Entry<Long, User> user : activeSet) {
            user.getValue().setActive(false);
        }
    }

    @Override
    public void activeUsers() {
        Set<Map.Entry<Long, User>> activeSet = userMap.entrySet();
        for (Map.Entry<Long, User> user : activeSet) {
            user.getValue().setActive(true);
        }
    }

    private void prepareUserList() {
        User user = new User();
        user.setId(id);
        user.setLogin("drakula1");
        user.setMail("mail@mail.pl");
        user.setAge(29);
        user.setCountry("Polska");
        user.setActive(true);
        saveUser(user);
    }
}
