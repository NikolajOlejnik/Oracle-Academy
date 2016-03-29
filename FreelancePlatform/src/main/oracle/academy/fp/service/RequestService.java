package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Request;

public interface RequestService {
    Request sendRequest(Long taskId, Request request);
    Request getRequestById(Long requestId);
}
