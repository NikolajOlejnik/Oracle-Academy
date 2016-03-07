package ua.oracleacademy.fp.dao;

import ua.oracleacademy.fp.domain.users.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    public void addUser(User user);
    public void deleteUser(long id);
    public void updateUser(User user);
    public List <User> getAllUsers();
    public User findUserById(long id);
    public User findUserByLogin(String login);
    public void makeAdmin(long userId);

}
