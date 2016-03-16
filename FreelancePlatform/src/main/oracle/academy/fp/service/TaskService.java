package main.oracle.academy.fp.service;

import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;

import java.util.List;

public interface TaskService {
    Task create (Task task);
    Task getById (Long taskId);
    List <Task> getTaskList();
    List <Task> getUserTaskList(Long userId);
    User getTaskOwner (Task task);
    List <Task> getTaskListByDescription(String request);
}
