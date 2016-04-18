package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.UserService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @RequestMapping(path = "users/{userId}", method = RequestMethod.DELETE)
    public String getUserDelete(@PathVariable long userId) {
        try {
            userService.delete(userId);
            return "redirect:/admin";
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
    }

    @RequestMapping(path = "/makeadmin/users/{userId}", method = RequestMethod.GET)
    public String makeAdmin (@PathVariable long userId) {
        User user = userAuthenticationService.getCurrentUser();
        if (user.getRole() != Role.ROLE_ADMIN) {
            return "redirect:/403";
        } else
            try {
                userService.makeAdmin(userId);
            } catch (UserException e) {
                e.printStackTrace();
                return "redirect:/404";
            }
        return "redirect:/admin";
    }

}
