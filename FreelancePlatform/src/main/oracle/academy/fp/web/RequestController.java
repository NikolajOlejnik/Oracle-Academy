package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exceptions.RequestException;
import main.oracle.academy.fp.exceptions.TaskException;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.RequestService;
import main.oracle.academy.fp.service.TaskService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RequestController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private UserAuthenticationService userAuthenticationService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/task/{taskId}/sendrequest", method = RequestMethod.POST)
    public String sendRequest(@PathVariable long taskId, @ModelAttribute("request") Request request, Map<String, Object> model) {
        requestService.sendRequest(taskId, request);
        return "redirect:/task/" + request.getTask().getId();
    }

    @RequestMapping(value = "/task/acceptrequest/{taskId}/{requestId}", method = RequestMethod.GET)
    public String acceptRequest(@PathVariable long taskId, @PathVariable long requestId) {
        Request request = requestService.getRequestById(requestId);
        try {
            taskService.acceptRequest(taskId, requestId);
        } catch (TaskException | RequestException e) {
            e.printStackTrace();
            return "/404";
        }
        return "redirect:/user/" + request.getUser().getId();
    }

}
