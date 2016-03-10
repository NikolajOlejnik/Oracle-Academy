package main.oracle.academy.fp.dao;

import main.oracle.academy.fp.model.User;

import java.util.List;

public interface UserDao {

	User create(User user);
	User getById(Long id);
	boolean delete(Long id);
	User update(User user);
	List<User> getAll();

}