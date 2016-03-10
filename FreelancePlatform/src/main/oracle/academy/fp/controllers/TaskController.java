package main.oracle.academy.fp.controllers;

import main.oracle.academy.fp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/alltask", method = RequestMethod.GET)
    public String getTaskList(ModelMap model){
        model.put("taskList", taskService.getTaskList());
        return "tasklist";
    }
}
