package main.oracle.academy.fp.web;

import main.oracle.academy.fp.exception.RequestException;
import main.oracle.academy.fp.exception.TaskException;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.service.RequestService;
import main.oracle.academy.fp.service.TaskService;
import main.oracle.academy.fp.service.impl.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    private RequestService requestService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/task/acceptRequest/{taskId}/{requestId}", method = RequestMethod.GET)
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
