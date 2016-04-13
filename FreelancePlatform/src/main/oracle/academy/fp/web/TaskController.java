package main.oracle.academy.fp.web;

import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.service.RequestService;
import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RequestService requestService;

    @RequestMapping(method = RequestMethod.GET)
    public String getTaskCreateForm() {
        return "task/create";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewTask(Task task) {
        taskService.create(task);
        return "redirect:/";
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.GET)
    public String getTask(Model model, @PathVariable long taskId) {
        Task task = taskService.getTaskWithRequests(taskId);
        model.addAttribute("task", task);
        return "task/task";
    }

    @RequestMapping(path = "/{taskId}/request", method = RequestMethod.POST)
    public String sendRequest(@PathVariable long taskId, Request request) {
        requestService.sendRequest(taskId, request);
        return "redirect:/task/" + request.getTask().getId();
    }

}
