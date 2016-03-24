package main.oracle.academy.fp.service;

import main.oracle.academy.fp.exceptions.UserException;
import main.oracle.academy.fp.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    User getById(Long id) throws UserException;

    User getByLogin (String login);

    void delete(Long id) throws UserException;

    User update(Long userId, User user) throws UserException;

    List<User> getUsersList();

    void makeAdmin(long userId) throws UserException;
}
