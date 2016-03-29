package main.oracle.academy.fp.dao.hibernate;

import main.oracle.academy.fp.dao.TaskDao;
import main.oracle.academy.fp.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl extends BaseDao<Task> implements TaskDao<Task> {

    @Override
    public List<Task> getAllActual() {
        Criteria criteria = super.getSession().createCriteria(Task.class);
        criteria.add(Restrictions.eq("status", true));
        criteria.addOrder(Order.desc("dateAdded"));
        return criteria.list();
    }

    /*
    void .size() avoid LazyInitializationException
   */

    @Override
    public Task getTaskWithRequests(Long taskId) {
        Task task = super.read(taskId);
        task.getRequestList().size();
        return task;
    }


}
