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
        return "ask-user-to-add";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUserPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "ask-user-to-delete";
    }

    @GetMapping("/user-deleted")
    public String deleteUser(@RequestParam("id") long id) {
        if (userService.deleteUser(id)) {
            return "redirect:/users";
        } else {
            return "redirect:/users/no_id";
        }
    }

    @GetMapping("/no_id")
    public String noUser() {
        return "no_id";
    }

    @GetMapping("/update")
    public String updateUserPage(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("user", new User());
        return "ask-user-to-update";
    }

    @PostMapping("/user-updated")
    public String updateUser(@ModelAttribute("user") User user) {
        if (userService.updateUser(user)) {
            return "redirect:/users";
        } else {
            return "redirect:/users/no_id";
        }
    }

}
