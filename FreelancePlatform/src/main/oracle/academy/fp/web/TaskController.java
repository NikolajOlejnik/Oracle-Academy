package main.oracle.academy.fp.web;

import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getTaskList(ModelMap model){
        model.put("taskList", taskService.getTaskList());

        return "tasklist";
    }

    @RequestMapping(path = "/task/{taskId}", method = RequestMethod.GET)
    public String getTask(ModelMap model,@PathVariable long taskId){
        Task task = taskService.getById(taskId);
        model.put("task", task);
        model.put("taskOwner", taskService.getTaskOwner(task));
        return "task";
    }
}
