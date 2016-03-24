package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.Request;

import java.util.List;

public interface RequestDao {
    Request create (Request request);
    Request getRequestById(Long requestId);
    Boolean update(Request request);
}
