package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Request;

import java.util.List;

public interface RequestService {
    Request addRequest(Request request);
    List<Request> getAllRequestByTaskId(Long taskId);
    Request getRequestById(Long requestId);
}
