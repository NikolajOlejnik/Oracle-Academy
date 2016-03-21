package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Request;

import java.util.List;

public interface RequestService {
    Request sendRequest(Request request);
    List<Request> getAllRequestByTaskId(Long taskId);
    Request getRequestById(Long requestId);
    List <Request> getAllUserRequests(Long id);
    List <Request> getAllRequestsCurrentUser();
}
