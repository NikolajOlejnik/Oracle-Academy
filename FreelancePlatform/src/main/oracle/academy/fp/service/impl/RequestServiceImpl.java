package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.repository.RequestRepository;
import main.oracle.academy.fp.repository.TaskRepository;
import main.oracle.academy.fp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Transactional
    @Override
    public Request sendRequest(Long taskId, Request request) {
        User user = userAuthenticationService.getCurrentUser();
        request.setTask(taskRepository.getOne(taskId));
        request.setUser(user);
        request.setDateAdded(new Date());
        request.setStatus(false);
        requestRepository.save(request);
        return request;
    }

    @Transactional(readOnly = true)
    @Override
    public Request getRequestById(Long requestId) {
        return requestRepository.getOne(requestId);
    }

}
