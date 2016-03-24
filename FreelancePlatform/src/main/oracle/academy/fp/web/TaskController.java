package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exceptions.UserException;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.RequestService;
import main.oracle.academy.fp.service.TaskService;
import main.oracle.academy.fp.service.UserService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/{userId}/tasklist", method = RequestMethod.GET)
    public String getUserTaskList(ModelMap model, @PathVariable long userId) {
        try {
            User user = userService.getById(userId);
            model.put("user", user);
            model.put("taskList", user.getTasks());
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "usertasklist";
    }


    @RequestMapping(path = "/mytasks", method = RequestMethod.GET)
    public String getMyTaskList(ModelMap model) {
        User user = userAuthenticationService.getCurrentUser();
        model.put("taskList", user.getTasks());
        model.put("user", user);
        return "usertasklist";
    }


    @RequestMapping(path = "/task/{taskId}", method = RequestMethod.GET)
    public String getTask(ModelMap model, @PathVariable long taskId) {
        Task task = taskService.getById(taskId);
        model.put("task", task);
        model.put("requestList", task.getRequestList());
        return "task";
    }

    @RequestMapping(path = "createtask", method = RequestMethod.GET)
    public String createTask() {
        return "newtask";
    }

    @RequestMapping(path = "/addtask", method = RequestMethod.POST)
    public String addNewTask(@ModelAttribute("task") Task task) {
        taskService.create(task);
        return "redirect:/";
    }
}
