package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.RequestDao;
import main.oracle.academy.fp.model.Request;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Request create(Request request) {
        Session session = null;
        try {
            request.setDateAdded(new Date());
            request.setStatus(false);
            session = sessionFactory.openSession();
            session.save(request);
        } catch ( Exception e){
            e.printStackTrace();
        }

        return request;
    }

    @Override
    public List<Request> getAllRequestByTaskId(Long taskId) {
        Session session = null;
        List<Request> requests = new ArrayList<>();

        try{
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Request.class);
            criteria.add(Restrictions.eq("taskId", taskId));
            criteria.addOrder(Order.desc("dateAdded"));
            requests = criteria.list();
        }catch ( Exception e){
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public Request getRequestById(Long requestId) {
        Request request = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            request = (Request) session.get(Request.class, requestId);
        } catch ( Exception e){
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public Boolean update(Request request) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.update(request);
            session.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
