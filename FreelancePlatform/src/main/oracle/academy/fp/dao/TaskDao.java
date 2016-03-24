package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.Task;

import java.util.List;

public interface TaskDao {
    Task create (Task task);
    Task getById (Long taskId);
    List<Task> getAllActual();
    List<Task> getTaskListByDescription(String request);
    Boolean update(Task task);
}
