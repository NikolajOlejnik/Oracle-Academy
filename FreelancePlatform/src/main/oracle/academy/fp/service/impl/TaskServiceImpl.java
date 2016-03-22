package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.exceptions.RequestException;
import main.oracle.academy.fp.exceptions.TaskException;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RequestDao requestDao;
    @Autowired
    private UserAuthenticationService userAuthenticationService;


    @Override
    @Transactional
    public Task create(Task task) {
        User user = userAuthenticationService.getCurrentUser();
        task.setUserId(user.getId());
        task.setDateAdded(new Date());
        task.setStatus(true);
        taskDao.create(task);
        return task;
    }

    @Override
    @Transactional
    public Task update(Task task) throws TaskException {
        if (getById(task.getId()) != null) {
            taskDao.update(task);
            return task;
        } else throw new TaskException();
    }

    @Override
    @Transactional
    public Task getById(Long taskId) {
        return taskDao.getById(taskId);
    }

    @Override
    @Transactional
    public List<Task> getActualTaskList() {
        return taskDao.getAllActual();
    }

    @Override
    @Transactional
    public List<Task> getUserTaskList(Long userId) {
        return taskDao.getTaskListByUserId(userId);
    }

    @Override
    @Transactional
    public User getTaskOwner(Task task) {
        return userDao.getById(task.getUserId());
    }

    @Override
    @Transactional
    public List<Task> getTaskListByDescription(String request) {
        return taskDao.getTaskListByDescription(request);
    }

    @Override
    @Transactional
    public Boolean acceptRequest(Long taskId, Long requestId) throws TaskException, RequestException {
        Task task = getById(taskId);
        Request request = requestDao.getRequestById(requestId);
        if (task != null) {
            if (request != null) {
                task.setStatus(false);
                request.setStatus(true);
                update(task);
                requestDao.update(request);
                return true;
            } else {
                throw new RequestException();
            }
        } else
            throw new TaskException();
    }

    @Override
    @Transactional
    public List<Task> getCurrentUserTaskList() {
        return taskDao.getTaskListByUserId(userAuthenticationService.getCurrentUser().getId());
    }
}
