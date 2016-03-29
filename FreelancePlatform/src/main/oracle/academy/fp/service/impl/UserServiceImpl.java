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
    @Transactional
    public User create(User user) {
        user.setEnabled(true);
        userDao.add(user);
        return user;
    }

    @Override
    @Transactional
    public User getById(Long id) throws UserException {
        User user = (User) userDao.read(id);
        if (user == null) {
            throw new UserException();
        }
        return user;
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        return (User) userDao.getByLogin(login);
    }

    @Override
    @Transactional
    public void delete(Long id) throws UserException {
        User user = (User) userDao.read(id);
        if (user != null) {
            userDao.delete(user.getId());
        } else {
            throw new UserException();
        }
    }

    @Override
    @Transactional
    public User update(Long userId, User userToUpdate) throws UserException {
        User user = (User) userDao.read(userId);
        if (user == null) {
            throw new UserException();
        }
        User currentUser = userAuthenticationService.getCurrentUser();
        if (currentUser.getId() == userId) {
            userToUpdate.setId(currentUser.getId());
            userToUpdate.setRole(currentUser.getRole());
            userDao.update(userToUpdate);
            return userToUpdate;
        } else if (currentUser.getRole() == Role.ROLE_ADMIN) {
            userDao.update(user);
            return user;
        } else {
                throw new UserException();
        }
    }

    @Override
    @Transactional
    public List<User> getUsersList() {

        return (List<User>) userDao.getAll();
    }

    @Override
    @Transactional
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
