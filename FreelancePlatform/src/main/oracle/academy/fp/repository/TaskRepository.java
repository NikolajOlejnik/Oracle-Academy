package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    @Query("SELECT task FROM Task task WHERE task.status = true")
    List<Task> getAllActual();

}
