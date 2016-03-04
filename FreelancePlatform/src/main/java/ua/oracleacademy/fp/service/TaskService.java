package ua.oracleacademy.fp.service;

import java.util.List;
import ua.oracleacademy.fp.domain.Task;

public interface TaskService {

	public void addTask(Task task);

	public List<Task> taskList();

	public void removeTask(Integer id);

	public List <Task> searchByDescription(String description);
}
