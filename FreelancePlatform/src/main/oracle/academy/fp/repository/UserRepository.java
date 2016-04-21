package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.User;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository class for <code>User</code> domain objects. Provided by Spring Data JPA
 *
 */
public interface UserRepository extends JpaRepository <User, Long> {

    /**
     * Retrieve <code>User</code> from the data store by login
     *
     * @param login Value to search for
     * @return the <code>User</code> if found
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */
    User findByLogin(String login) throws DataAccessException;

    /**
     * Retrieve all <code>User</code>s from the data store
     *
     * @return a <code>Collection</code> of <code>User</code>s (or an empty <code>Collection</code> if data store
     * is empty
     */
    @Query("SELECT user FROM User user")
    List<User> getAll() throws DataAccessException;

}