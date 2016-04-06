package main.oracle.academy.fp.web;

import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getTaskList(ModelMap model) {
        model.put("taskList", taskService.getActualTaskList());
        return "index";
    }


}
