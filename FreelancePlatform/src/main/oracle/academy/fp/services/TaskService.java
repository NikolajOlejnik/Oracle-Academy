package main.oracle.academy.fp.services;

import main.oracle.academy.fp.model.Task;

import java.util.List;

public interface TaskService {
    Task create (Task task);

    List <Task> getTaskList();
}
