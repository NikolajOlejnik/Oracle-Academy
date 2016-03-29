package main.oracle.academy.fp.dao;

public interface UserDao <User> extends Dao <User> {
	User getByLogin(String login);
}