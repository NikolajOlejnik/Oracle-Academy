package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.Task;

import java.util.List;

public interface TaskDao <Task> extends Dao <Task> {
    List<Task> getAllActual();
}
