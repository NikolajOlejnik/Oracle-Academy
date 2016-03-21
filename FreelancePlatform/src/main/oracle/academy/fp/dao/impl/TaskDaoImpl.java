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
        Session session = null;
        try {
            task.setDateAdded(new Date());
            session = sessionFactory.openSession();
            task.setStatus(true);
            session.save(task);
        } catch ( Exception e){
            e.printStackTrace();
        }

        return task;
    }

    @Override
    public Task getById(Long taskId) {
        Task task = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            task = (Task) session.get(Task.class, taskId);
        } catch ( Exception e){
            e.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> getAllActual() {
        Session session = null;
        List<Task> tasks = new ArrayList<>();

        try{
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Task.class);
            Criterion actual = Restrictions.eq("status", true);
            criteria.add(actual);
            criteria.addOrder(Order.desc("dateAdded"));
            tasks = criteria.list();

        }catch ( Exception e){
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> getTaskListByDescription(String request) {
        Session session = null;
        List<Task> tasks = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Task.class);
            Criterion byTitle = Restrictions.like("title", "%" + request + "%");
            Criterion byDescription = Restrictions.like("description", "%" + request+"%");
            LogicalExpression orExp = Restrictions.or(byTitle, byDescription);
            criteria.add(orExp);
            criteria.addOrder(Order.desc("dateAdded"));
            tasks = criteria.list();

        }catch ( Exception e){
            e.printStackTrace();
        }
        return tasks;

    }

    @Override
    public List<Task> getTaskListByUserId(Long userId) {
        Session session = null;
        List<Task> tasks = new ArrayList<>();
        try{
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Task.class);
            Criterion byUserID = Restrictions.eq("userId", userId);
            criteria.add(byUserID);
            criteria.addOrder(Order.desc("dateAdded"));
            tasks = criteria.list();

        }catch ( Exception e){
            e.printStackTrace();
        }

        return tasks;
    }

    @Override
    public Boolean update(Task task) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.update(task);
            session.flush();
            return true;
        } catch ( Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
