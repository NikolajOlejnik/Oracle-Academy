package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDaoImpl extends BaseDao <Request> implements RequestDao <Request>  {

    @Autowired
    private SessionFactory sessionFactory;

    public Request create(Request request) {
        sessionFactory.getCurrentSession().save(request);
        return request;
    }




}
