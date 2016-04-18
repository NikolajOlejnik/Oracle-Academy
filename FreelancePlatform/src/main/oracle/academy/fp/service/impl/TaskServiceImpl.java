package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.exception.RequestException;
import main.oracle.academy.fp.exception.TaskException;
import main.oracle.academy.fp.model.Request;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.repository.RequestRepository;
import main.oracle.academy.fp.repository.TaskRepository;
import main.oracle.academy.fp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Transactional
    @Override
    public Task create(Task task) {
        User user = userAuthenticationService.getCurrentUser();
        task.setUser(user);
        task.setDateAdded(new Date());
        task.setStatus(true);
        taskRepository.save(task);
        return task;
    }

    @Transactional
    @Override
    public Task update(Task task) throws TaskException {
        if (getById(task.getId()) != null) {
            taskRepository.save(task);
            return task;
        } else throw new TaskException();
    }

    @Transactional(readOnly = true)
    @Override
    public Task getById(Long taskId) {
        Task task = taskRepository.findOne(taskId);
        task.getRequestList().size();
        return task;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Task> getActualTaskList() {
        return taskRepository.getAllActual();
    }

    @Transactional
    @Override
    public Boolean acceptRequest(Long taskId, Long requestId) throws TaskException, RequestException {
        Task task = getById(taskId);
        Request request = requestRepository.getOne(requestId);
        if (task != null) {
            if (request != null) {
                task.setStatus(false);
                request.setStatus(true);
                update(task);
                requestRepository.save(request);
                return true;
            } else {
                throw new RequestException();
            }
        } else
            throw new TaskException();
    }

}
