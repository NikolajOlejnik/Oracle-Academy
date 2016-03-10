package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.Role;
import main.oracle.academy.fp.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            user.setRole(Role.ROLE_USER);
            user.setEnabled(true);
            session.save(user);
        } catch ( Exception e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User getById(Long id) {

        return null;
    }

    @Override
    public boolean delete(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query q = session.createQuery("delete User where id = " + id);
            q.executeUpdate();
        } catch ( Exception e){
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {

        Session session = null;
        List<User> users = new LinkedList<>();

        try{
            session = sessionFactory.openSession();
            users = session.createQuery("FROM User").list();


        }catch ( Exception e){
            e.printStackTrace();
        }
        return users;

    }


}
