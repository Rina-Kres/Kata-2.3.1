package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "user/userList";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/addUser";
    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String showEditUserForm(@RequestParam("id") int id, Model model) {
        Optional<User> userById = userService.findById(id);
        userById.ifPresent(user -> model.addAttribute("user", user));
        return userById.isPresent() ? "user/editUser" : "redirect:/users";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/editUser";
        }
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String showDeleteConfirmation(@RequestParam("id") int id, Model model) {
        Optional<User> userById = userService.findById(id);
        userById.ifPresent(user -> model.addAttribute("user", user));
        return userById.isPresent() ? "user/deleteUser" : "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}