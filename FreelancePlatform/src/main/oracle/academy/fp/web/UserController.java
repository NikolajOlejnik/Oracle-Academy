package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.UserService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/error";
        }
        System.out.println(user);
        userService.create(user);
        return "auth/success";
    }

    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public String getUserProfile(Model model, @PathVariable long userId) {
        try {
            model.addAttribute("user", userService.getById(userId));
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "user/profile";
    }

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String getCurrentUserAccount(ModelMap model) {
        model.addAttribute("user", userAuthenticationService.getCurrentUser());
        return "user/profile";
    }

    @RequestMapping(path = "/requests", method = RequestMethod.GET)
    public String getMyRequestsList(Model model) {
        User user = userAuthenticationService.getCurrentUserWithJoins();
        model.addAttribute("user", user);
        return "user/requests";
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    public String getMyTaskList(Model model) {
        User user = userAuthenticationService.getCurrentUserWithJoins();
        model.addAttribute("user", user);
        return "user/tasks";
    }

    @RequestMapping(path = "/{userId}/tasks", method = RequestMethod.GET)
    public String getUserTaskList(Model model, @PathVariable long userId) {
        try {
            User user = userService.getUserWithTasks(userId);
            model.addAttribute("user", user);
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "user/tasks";
    }

    @RequestMapping(path = "/{userId}/edit", method = RequestMethod.GET)
    public String editUser(Model model, @PathVariable long userId) {
        User user = userAuthenticationService.getCurrentUser();
        if (user.getRole() == Role.ROLE_USER && user.getId() != userId) {
            return "redirect:/403";
        } else
            try {
                model.addAttribute(userService.getById(userId));
            } catch (UserException e) {
                e.printStackTrace();
                return "redirect:/404";
            }
        return "user/edit";
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.POST)
    public String edit(User user, @PathVariable Long userId, Model model) {
        try {
            userService.update(userId, user);
            model.addAttribute(userService.getById(user.getId()));
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "redirect:/user/" + userId;
    }

}