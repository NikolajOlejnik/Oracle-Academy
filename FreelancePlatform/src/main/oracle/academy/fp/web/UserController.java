package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.UserService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap model) {
        model.put("usersList", userService.getUsersList());
        return "admin/usersList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerNewUser (@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "auth/errors";
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
            return "redirect:/errors/404";
        }
        return "users/profile";
    }

    @RequestMapping(path = "/profile", method = RequestMethod.GET)
    public String getCurrentUserProfile(ModelMap model) {
        model.addAttribute("user", userAuthenticationService.getCurrentUser());
        return "users/profile";
    }

    @RequestMapping(path = "/requests", method = RequestMethod.GET)
    public String getCurrentUserRequests(Model model) {
        User user = userAuthenticationService.getCurrentUser();
        model.addAttribute("user", user);
        return "users/requests";
    }

    @RequestMapping(path = "/tasks", method = RequestMethod.GET)
    public String getCurrentUserTasks(Model model) {
        User user = userAuthenticationService.getCurrentUser();
        model.addAttribute("user", user);
        return "users/tasks";
    }

    @RequestMapping(path = "/{userId}/tasks", method = RequestMethod.GET)
    public String getUserTasks(Model model, @PathVariable long userId) {
        try {
            model.addAttribute("user", userService.getById(userId));
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/errors/404";
        }
        return "users/tasks";
    }

    @RequestMapping(path = "/{userId}/edit", method = RequestMethod.GET)
    public String getUserEditForm (Model model, @PathVariable long userId) {
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
        return "users/edit";
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.POST)
    public String editUser (User user, @PathVariable Long userId, Model model) {
        try {
            userService.update(userId, user);
            model.addAttribute(userService.getById(user.getId()));
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "redirect:/users/" + userId;
    }

}