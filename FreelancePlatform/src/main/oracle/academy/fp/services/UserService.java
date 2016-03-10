package main.oracle.academy.fp.services;

import main.oracle.academy.fp.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User getById(Long id);

    void delete(Long id);

    User update(User user);

    List<User> getUsersList();
}
