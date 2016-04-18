package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.exception.UserException;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.repository.UserRepository;
import main.oracle.academy.fp.service.UserService;
import main.oracle.academy.fp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Transactional
    @Override
    public User create(User user) {
        user.setEnabled(true);
        userRepository.save(user);
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) throws UserException {
        User user = userRepository.getOne(id);
        if (user == null) {
            throw new UserException();
        }
        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public User findByLogin(String login) {
        User user = userRepository.findByLogin(login);
        user.getTasks().size();
        user.getRequests().size();
        return user;
    }

    @Transactional
    @Override
    public void delete(Long id) throws UserException {
        User user = userRepository.getOne(id);
        if (user != null) {
            userRepository.delete(user.getId());
        } else {
            throw new UserException();
        }
    }

    @Transactional
    @Override
    public User update(Long userId, User userToUpdate) throws UserException {
        User currentUser = userAuthenticationService.getCurrentUser();
        if (currentUser.getId() == userId) {
            userToUpdate.setRole(currentUser.getRole());
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else if (currentUser.getRole() == Role.ROLE_ADMIN) {
            userRepository.save(userToUpdate);
            return userToUpdate;
        } else {
                throw new UserException();
        }
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public List<User> getUsersList() {
        return userRepository.getAll();
    }

    @Transactional
    @Override
    public void makeAdmin(long userId) throws UserException {
        User user = userRepository.getOne(userId);
        if (user == null) {
            throw new UserException();
        } else {
            user.setRole(Role.ROLE_ADMIN);
            userRepository.save(user);
        }
    }



}
