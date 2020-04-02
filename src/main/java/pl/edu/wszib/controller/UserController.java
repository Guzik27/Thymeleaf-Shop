package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("users")
    public String users(Model model) {
        model.addAttribute("users", userDao.getUsers()); // wywołujemy metodę bezpośrednio
        return "users";
    }

    @GetMapping("users/remove/{userId}")  /*?? id samo??*/
    public String removeUser(@PathVariable Long userId){
        userDao.removeUser(userId);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User()); // przekazujemy nowy obiekt produktu
        return "user";
    }

    @PostMapping("users/save")
    public String saveUser(User user) {
        userDao.saveUser(user);
        return "redirect:/users"; /* przekierowanie do produktów */
    }

    @GetMapping("users/edit/{userId}")
    public String editUser(@PathVariable Long userId, Model model) {
        User user = userDao.getById(userId);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("users/inactive")
    public String inactiveUsers(){
        userDao.inactiveUsers();
        return "redirect:/users";
    }

    @GetMapping("users/active")
    public String activeUsers(){
        userDao.activeUsers();
        return "redirect:/users";
    }
}
