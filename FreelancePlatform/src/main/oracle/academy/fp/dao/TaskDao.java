package main.oracle.academy.fp.dao;


import java.util.List;

public interface TaskDao <Task> extends Dao <Task> {
    List <Task> getAllActual();
    Task getTaskWithRequests(Long taskId);
}
