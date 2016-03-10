package main.oracle.academy.fp.services.impl;

import main.oracle.academy.fp.services.UserService;
import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User create(User user) {
        userDao.create(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    @Transactional
    public List<User> getUsersList() {

        return userDao.getAll();
    }


}
