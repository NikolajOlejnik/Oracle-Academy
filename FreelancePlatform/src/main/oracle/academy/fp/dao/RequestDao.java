package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.Request;

import java.util.List;

public interface RequestDao {
    Request create (Request request);
    List<Request> getAllRequestByTaskId(Long taskId);
    Request getRequestById(Long requestId);
    Boolean update(Request request);
    List<Request> getAllUserRequests(Long id);
}
