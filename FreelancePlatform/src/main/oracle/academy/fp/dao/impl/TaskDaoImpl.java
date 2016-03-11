package main.oracle.academy.fp.dao.impl;

import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Task;
import main.oracle.academy.fp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public List<Task> getAll() {
        Session session = null;
        List<Task> tasks = new ArrayList<>();

        try{
            session = sessionFactory.openSession();
            tasks = session.createQuery("FROM Task").list();


        }catch ( Exception e){
            e.printStackTrace();
        }
        System.out.println(tasks);
        return tasks;
    }

}
