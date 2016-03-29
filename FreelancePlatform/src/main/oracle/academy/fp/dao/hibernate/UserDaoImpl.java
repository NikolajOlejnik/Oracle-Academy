package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.UserDao;
import main.oracle.academy.fp.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl extends BaseDao <User> implements UserDao <User> {

    public UserDaoImpl() {
    }

    public User getByLogin(String login) {
        Criteria criteria = super.getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }
}
