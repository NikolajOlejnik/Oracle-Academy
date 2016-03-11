package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public Task create(Task task) {
        taskDao.create(task);
        return task;
    }

    @Override
    @Transactional
    public Task getById(Long taskId) {
        Task task = taskDao.getById(taskId);
        return task;
    }

    @Override
    @Transactional
    public List<Task> getTaskList() {
        return taskDao.getAll();
    }

    @Override
    @Transactional
    public User getTaskOwner(Task task) {
        User user = userDao.getById(task.getUserId());
        return user;
    }
}
