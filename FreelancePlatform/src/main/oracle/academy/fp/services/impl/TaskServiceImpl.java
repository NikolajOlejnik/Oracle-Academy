package main.oracle.academy.fp.services.impl;

import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    @Transactional
    public Task create(Task task) {
        taskDao.create(task);
        return task;
    }

    @Override
    @Transactional
    public List<Task> getTaskList() {
        return taskDao.getAll();
    }
}
