package main.oracle.academy.fp.service;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.User;

import java.util.List;

/**
 * Provides all of business operations with <code>User</code> objects that we’re interested in.
 * Also provides all transactions.
 *
 */
public interface UserService {

    User create(User user);

    User getById(Long id) throws UserException;

    User findByLogin(String login);

    User update(Long userId, User user) throws UserException;

    List<User> getUsersList();

    void makeAdmin(long userId) throws UserException;

    //TODO: void delete(Long id) throws UserException;

}
