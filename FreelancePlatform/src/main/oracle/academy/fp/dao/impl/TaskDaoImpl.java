package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Task create(Task task) {
        sessionFactory.getCurrentSession().save(task);
        return task;
    }

    @Override
    public Task getById(Long taskId) {
        return (Task) sessionFactory.getCurrentSession().get(Task.class, taskId);
    }

    @Override
    public List<Task> getAllActual() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("status", true));
        criteria.addOrder(Order.desc("dateAdded"));
        return criteria.list();
    }

    @Override
    public List<Task> getTaskListByDescription(String request) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        Criterion byTitle = Restrictions.like("title", "%" + request + "%");
        Criterion byDescription = Restrictions.like("description", "%" + request + "%");
        criteria.add(Restrictions.or(byTitle, byDescription));
        criteria.addOrder(Order.desc("dateAdded"));
        return criteria.list();
    }

    @Override
    public List<Task> getTaskListByUserId(Long userId) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.addOrder(Order.desc("dateAdded"));
        return criteria.list();
    }

    @Override
    public Boolean update(Task task) {
        sessionFactory.getCurrentSession().update(task);
        return true;
    }
}
