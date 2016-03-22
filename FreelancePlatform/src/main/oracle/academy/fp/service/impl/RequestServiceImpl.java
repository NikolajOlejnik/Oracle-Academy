package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    @Transactional
    public Request sendRequest(Request request) {
        User user = userAuthenticationService.getCurrentUser();
        request.setUserId(user.getId());
        request.setUserName(user.getName());
        request.setDateAdded(new Date());
        request.setStatus(false);
        requestDao.create(request);
        return request;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Request> getAllRequestByTaskId(Long taskId) {

        return requestDao.getAllRequestByTaskId (taskId);
    }

    @Override
    @Transactional(readOnly = true)
    public Request getRequestById(Long requestId) {
        return requestDao.getRequestById(requestId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Request> getAllUserRequests(Long id) {
        return requestDao.getAllUserRequests(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Request> getAllRequestsCurrentUser() {
        return requestDao.getAllUserRequests(userAuthenticationService.getCurrentUser().getId());
    }

}
