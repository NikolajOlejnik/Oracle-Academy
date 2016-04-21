package main.oracle.academy.fp.service;

import main.oracle.academy.fp.exception.RequestException;
import main.oracle.academy.fp.exception.TaskException;
import main.oracle.academy.fp.model.Task;

import java.util.List;

/**
 * Provides all of business operations with <code>Task</code> objects that we’re interested in.
 * Also provides all transactions.
 *
 */
public interface TaskService {
    Task create (Task task);
    Task update (Task task) throws TaskException;
    Task getById (Long taskId);
    List <Task> getActualTaskList();
    Boolean acceptRequest(Long taskId, Long requestId) throws TaskException, RequestException;
}
