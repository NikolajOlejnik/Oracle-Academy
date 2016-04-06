package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.TaskService;
import main.oracle.academy.fp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/{userId}/taskList", method = RequestMethod.GET)
    public String getUserTaskList(ModelMap model, @PathVariable long userId) {
        try {
            User user = userService.getUserWithTasks(userId);
            model.put("user", user);
            model.put("taskList", user.getTasks());
        } catch (UserException e) {
            e.printStackTrace();
            return "redirect:/404";
        }
        return "userTaskList";
    }




    @RequestMapping(path = "/task/{taskId}", method = RequestMethod.GET)
    public String getTask(ModelMap model, @PathVariable long taskId) {
        Task task = taskService.getTaskWithRequests(taskId);
        model.put("task", task);
        return "task";
    }

    @RequestMapping(path = "createTask", method = RequestMethod.GET)
    public String createTask() {
        return "newTask";
    }

    @RequestMapping(path = "/addTask", method = RequestMethod.POST)
    public String addNewTask(@ModelAttribute("task") Task task) {
        taskService.create(task);
        return "redirect:/";
    }
}
