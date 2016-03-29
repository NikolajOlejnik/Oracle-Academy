package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.dao.Dao;
import main.oracle.academy.fp.exceptions.UserException;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.service.UserService;
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

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Override
    public User create(User user) {
        user.setEnabled(true);
        userDao.add(user);
        return user;
    }

    @Override
    public User getById(Long id) throws UserException {
        User user = (User) userDao.read(id);
        if (user == null) {
            throw new UserException();
        }
        return user;
    }

    @Override
    public User getUserWithTasks(long userId) throws UserException {
        User user = (User) userDao.getUserWithTasks(userId);
        if (user == null) {
            throw new UserException();
        }
        return user;
    }

    @Override
    public User getByLoginWithJoins(String login) {
        return (User) userDao.getByLoginWithJoins(login);
    }

    @Override
    public User getByLogin(String login) {
        return (User) userDao.getByLogin(login);
    }

    @Override
    public void delete(Long id) throws UserException {
        User user = (User) userDao.read(id);
        if (user != null) {
            userDao.delete(user.getId());
        } else {
            throw new UserException();
        }
    }

    @Override
    public User update(Long userId, User userToUpdate) throws UserException {
        User currentUser = userAuthenticationService.getCurrentUser();
        if (currentUser.getId() == userId) {
            userToUpdate.setRole(currentUser.getRole());
            userDao.update(userToUpdate);
            return userToUpdate;
        } else if (currentUser.getRole() == Role.ROLE_ADMIN) {
            userDao.update(userToUpdate);
            return userToUpdate;
        } else {
                throw new UserException();
        }
    }

    @Override
    public List<User> getUsersList() {

        return (List<User>) userDao.getAll();
    }

    @Override
    public void makeAdmin(long userId) throws UserException {
        User user = (User) userDao.read(userId);
        if (user == null) {
            throw new UserException();
        } else {
            user.setRole(Role.ROLE_ADMIN);
            userDao.update(user);
        }
    }

}
