package ua.oracleacademy.fp.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import ua.oracleacademy.fp.dao.TaskDao;
import ua.oracleacademy.fp.domain.Task;
 
@Service
public class TaskServiceImpl implements TaskService {
 
    @Autowired
    private TaskDao taskDao;
 
    @Transactional
    public void addTask(Task task) {
        taskDao.addTask(task);
    }
 
    @Transactional
    public List<Task> taskList() {
 
        return taskDao.taskList();
    }
 
    @Transactional
    public void removeTask(Integer id) {
        taskDao.removeTask(id);
    }

    @Transactional
    public List<Task> searchByDescription(String description) {
        return taskDao.searchByDescription(description);
    }
}
