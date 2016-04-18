package main.oracle.academy.fp.repository;

import main.oracle.academy.fp.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository <User, Long> {

    User findByLogin(String login) throws DataAccessException;

    @Query("SELECT user FROM User user")
    List<User> getAll() throws DataAccessException;

}
