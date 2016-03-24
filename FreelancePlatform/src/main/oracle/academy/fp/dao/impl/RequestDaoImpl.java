package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Request create(Request request) {
        sessionFactory.getCurrentSession().save(request);
        return request;
    }

    @Override
    public Request getRequestById(Long requestId) {
        return (Request) sessionFactory.getCurrentSession().get(Request.class, requestId);
    }

    @Override
    public Boolean update(Request request) {
        sessionFactory.getCurrentSession().update(request);
        return true;
    }


}
