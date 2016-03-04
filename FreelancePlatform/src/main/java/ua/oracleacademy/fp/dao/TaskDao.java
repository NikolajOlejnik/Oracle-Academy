package ua.oracleacademy.fp.dao;

import java.util.List;
import ua.oracleacademy.fp.domain.Task;

public interface TaskDao {

	public void addTask(Task task);

	public List<Task> taskList ();

	public void removeTask (Integer id);

	List<Task> searchByDescription(String description);
}