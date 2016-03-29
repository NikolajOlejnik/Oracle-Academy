package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao<User> {

    public UserDaoImpl() {
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        Criteria criteria = super.getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    /*
   void .size() avoid LazyInitializationException
    */

    @Override
    @Transactional
    public User getByLoginWithJoins(String login) {
        Criteria criteria = super.getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        User user = (User) criteria.uniqueResult();
        user.getRequests().size();
        user.getTasks().size();
        return user;
    }

    @Override
    @Transactional
    public User getUserWithTasks(long userId) {
        User user = super.read(userId);
        user.getTasks().size();
        return user;
    }
}
