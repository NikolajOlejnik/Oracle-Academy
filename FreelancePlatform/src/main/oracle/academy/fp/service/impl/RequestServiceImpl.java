package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Request sendRequest(Long taskId, Request request) {
        User user = userAuthenticationService.getCurrentUser();
        request.setUser(user);
        request.setTask((Task) taskDao.read(taskId));
        request.setDateAdded(new Date());
        request.setStatus(false);
        requestDao.add(request);
        return request;
    }


    @Override
    @Transactional(readOnly = true)
    public Request getRequestById(Long requestId) {
        return (Request) requestDao.read(requestId);
    }

}
