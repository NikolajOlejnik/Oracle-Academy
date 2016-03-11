package main.oracle.academy.fp.web;

import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService ;


    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public String getUserList(ModelMap model){
        model.put("usersList", userService.getUsersList());

        return "userlist";
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public String getUserProfile(ModelMap model, @PathVariable long userId){
        model.put("user", userService.getById(userId));
        return "profile";
    }
//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    public String login(ModelMap model){
//        return "login";
//    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String processRegistration(@ModelAttribute("userForm") User user,
                                      Map<String, Object> model) {
        userService.create(user);
        System.out.println("----------");
        System.out.println(user);
        return "redirect:/admin";
    }

//    @RequestMapping(path = "/edit/{userId}", method = RequestMethod.GET)
//    public String getUserEditForm(ModelMap model, @PathVariable long userId){
//        System.out.println(userId);
//        return "addUser";
//    }

    @RequestMapping(path = "/delete/{userId}", method = RequestMethod.GET)
    public String getUserDelete(ModelMap model, @PathVariable long userId){
        userService.delete(userId);
        System.out.println(userId);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/reg", method = RequestMethod.GET)
    public String regNewUser(ModelMap model){

        return "register";
    }
}