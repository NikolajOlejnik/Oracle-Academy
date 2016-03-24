package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Request;

import java.util.List;

public interface RequestService {
    Request sendRequest(Request request);
    Request getRequestById(Long requestId);
}
