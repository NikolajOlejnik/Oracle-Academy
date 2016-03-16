package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;

import java.util.List;

public interface TaskDao {
    Task create (Task task);
    Task getById (Long taskId);
    List<Task> getAll();
    List<Task> getTaskListByDescription(String request);
    List<Task> getTaskListByUserId(Long userId);
}
