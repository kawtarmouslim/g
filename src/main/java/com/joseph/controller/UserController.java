package com.joseph.controller;

import com.joseph.entity.User;
import com.joseph.service.Impl.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
    private UserServiceImp userService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.selectAllUsers();
        model.addAttribute("users", users);
        return "list-user";
    }

    @GetMapping("/new")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        return "from-user";
    }

   @PostMapping("/insert")
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam Long id, Model model) {
        User user = userService.selectUser(id);
        model.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:list";
    }
}
