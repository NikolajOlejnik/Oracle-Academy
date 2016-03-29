package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao<User> {

    public UserDaoImpl() {
    }

    @Override
    public User getByLogin(String login) {
        Criteria criteria = super.getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }

    /*
   void .size() avoid LazyInitializationException
    */

    @Override
    public User getByLoginWithJoins(String login) {
        Criteria criteria = super.getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        User user = (User) criteria.uniqueResult();
        user.getRequests().size();
        user.getTasks().size();
        return user;
    }

    @Override
    public User getUserWithTasks(long userId) {
        User user = super.read(userId);
        user.getTasks().size();
        return user;
    }
}
