package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    public Request sendRequest(Long taskId, Request request) {
        User user = userAuthenticationService.getCurrentUser();
        request.setTask((Task) taskDao.read(taskId));
        request.setUser(user);
        request.setDateAdded(new Date());
        request.setStatus(false);
        requestDao.create(request);
        return request;
    }


    @Override
    public Request getRequestById(Long requestId) {
        return (Request) requestDao.read(requestId);
    }

}
