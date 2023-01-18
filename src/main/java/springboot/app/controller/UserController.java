package springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springboot.app.model.User;
import springboot.app.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/default-users")
    public String defaultUsers() {
        userService.defaultUsers();
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addUserPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "input-user";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUser(id));
        return "input-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserPage(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
