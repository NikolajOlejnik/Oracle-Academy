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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @RequestMapping(path = "/myAccount", method = RequestMethod.GET)
    public String getCurrentUserAccount(ModelMap model) {
        model.put("user", userAuthenticationService.getCurrentUser());
        return "profile";
    }

    @RequestMapping(path = "/myRequests", method = RequestMethod.GET)
    public String getMyRequestsList(ModelMap model) {
        User user = userAuthenticationService.getCurrentUserWithJoins();
        model.put("user", user);
        return "requestList";
    }

    @RequestMapping(path = "/myTasks", method = RequestMethod.GET)
    public String getMyTaskList(ModelMap model) {
        User user = userAuthenticationService.getCurrentUserWithJoins();
        model.put("user", user);
        return "userTaskList";
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String getUserProfile(ModelMap model, @PathVariable long userId) {
        try {
            model.put("user", userService.getById(userId));
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "profile";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
                                      Map<String, Object> model) {
        userService.create(user);
        return "register/success";
    }

    @RequestMapping(path = "/reg", method = RequestMethod.GET)
    public String regNewUser() {
        return "register";
    }

    @RequestMapping(path = "/edit/user/{userId}", method = RequestMethod.GET)
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
        return "userEditForm";
    }

    @RequestMapping(path = "/user/{userId}/update", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editeduser") User user, @PathVariable Long userId, Model model) {
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