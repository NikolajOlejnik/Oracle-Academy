package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User create(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return  (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public boolean delete(User user) {
            sessionFactory.getCurrentSession().delete(user);
            return true;
    }

    //ДОПИСАТЬ!!
    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public User getByLogin(String login) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User)criteria.uniqueResult();
    }


}
