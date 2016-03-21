package main.oracle.academy.fp.web;

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

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getTaskList(ModelMap model) {
        model.put("taskList", taskService.getTaskList());

        return "index";
    }

    @RequestMapping(path = "/user/{userId}/tasklist", method = RequestMethod.GET)
    public String getUserTaskList(ModelMap model, @PathVariable long userId) {
        model.put("taskList", taskService.getUserTaskList(userId));
        model.put("user", userService.getById(userId));
        return "usertasklist";
    }


    @RequestMapping(path = "/mytasks", method = RequestMethod.GET)
    public String getMyTaskList(ModelMap model) {
        User user = userAuthenticationService.getCurrentUser();
        model.put("taskList", taskService.getUserTaskList(user.getId()));
        model.put("user", user);
        return "usertasklist";
    }


//    @RequestMapping(path = "/index", method = RequestMethod.GET)
//    public String index(ModelMap model){
//        model.put("taskList", taskService.getTaskList());
//        return "index";
//    }

//    @RequestMapping(path = "/search", method = RequestMethod.GET)
//    public String getTaskListByDescription (ModelMap model, @ModelAttribute("request") String request){
//        model.put("taskList", taskService.getTaskListByDescription(request));
//
//        return "searchresult";
//    }

    @RequestMapping(path = "/task/{taskId}", method = RequestMethod.GET)
    public String getTask(ModelMap model, @PathVariable long taskId) {
        Task task = taskService.getById(taskId);
        model.put("task", task);
        model.put("taskOwner", taskService.getTaskOwner(task));
        model.put("requestList", requestService.getAllRequestByTaskId(task.getId()));
        return "task";
    }

    @RequestMapping(path = "createtask", method = RequestMethod.GET)
    public String createTask() {

        return "newtask";
    }

    @RequestMapping(path = "/addtask", method = RequestMethod.POST)
    public String addNewTask(@ModelAttribute("task") Task task,
                             Map<String, Object> model) {

        User user = userAuthenticationService.getCurrentUser();
        task.setUserId(user.getId());
        taskService.create(task);
        return "redirect:/";
    }
}
