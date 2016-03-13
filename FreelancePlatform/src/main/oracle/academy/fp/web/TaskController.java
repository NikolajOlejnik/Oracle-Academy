package main.oracle.academy.fp.web;

import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.TaskService;
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
    private UserAuthenticationService userAuthenticationService ;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getTaskList(ModelMap model){
        model.put("taskList", taskService.getTaskList());

        return "tasklist";
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String getTaskListByDescription (ModelMap model, @ModelAttribute("request") String request){
        model.put("taskList", taskService.getTaskListByDescription(request));

        return "searchresult";
    }

    @RequestMapping(path = "/task/{taskId}", method = RequestMethod.GET)
    public String getTask(ModelMap model,@PathVariable long taskId){
        Task task = taskService.getById(taskId);
        model.put("task", task);
        model.put("taskOwner", taskService.getTaskOwner(task));
        return "task";
    }

    @RequestMapping(path = "createtask", method = RequestMethod.GET)
    public String createTask(){

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
