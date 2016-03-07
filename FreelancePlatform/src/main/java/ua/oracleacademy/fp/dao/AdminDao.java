package ua.oracleacademy.fp.dao;

import ua.oracleacademy.fp.domain.users.User;

import java.util.List;

public interface AdminDao {
    public void addAdmin (User user);
    public void removeAdmin(long id);
    public void updateAdmin(User user);
    public List getAllAdmins();
}
