package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class for <code>Task</code> domain objects. Provided by Spring Data JPA
 *
 */
public interface TaskRepository extends JpaRepository <Task, Long> {

    /**
     * Retrieve all actual <code>Tasks</code>s from the data store
     *
     * @return a <code>Collection</code> of <code>User</code>s (or an empty <code>Collection</code> if none
     * found)
     */
    @Query("SELECT task FROM Task task WHERE task.status = true")
    List<Task> getAllActual();

}