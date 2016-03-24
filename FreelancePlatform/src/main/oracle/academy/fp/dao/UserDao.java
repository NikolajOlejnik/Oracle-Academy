package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.User;

import java.util.List;

public interface UserDao {
	User create(User user);
	User getById(Long id);
	boolean delete(User user);
	User update(User user);
	List<User> getAll();
	User getByLogin(String login);


}