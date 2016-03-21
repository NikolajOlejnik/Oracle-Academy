package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao requestDao;

    @Override
    @Transactional
    public Request addRequest(Request request) {
        requestDao.create(request);
        return request;
    }


    @Override
    @Transactional
    public List<Request> getAllRequestByTaskId(Long taskId) {

        return requestDao.getAllRequestByTaskId (taskId);
    }

    @Override
    @Transactional
    public Request getRequestById(Long requestId) {
        return requestDao.getRequestById(requestId);
    }

}
