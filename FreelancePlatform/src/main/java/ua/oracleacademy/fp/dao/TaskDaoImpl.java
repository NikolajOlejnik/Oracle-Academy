package ua.oracleacademy.fp.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import ua.oracleacademy.fp.domain.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addTask(Task task) {
		//sessionFactory.getCurrentSession().save(task);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(task);

		transaction.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Task> taskList() {

		List<Task> tasks;
		//return sessionFactory.getCurrentSession().createQuery("from Task")
			//.list();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		tasks = session.createQuery("from Task").list();

		transaction.commit();
		session.close();

		return tasks;
	}

	public void removeTask (Integer id) {
		Task task = (Task) sessionFactory.getCurrentSession().load(
				Task.class, id);
		if (null != task) {
			sessionFactory.getCurrentSession().delete(task);
		}

	}

	public List<Task> searchByDescription(String description) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


		Criteria cr = session.createCriteria(Task.class);
		cr.add(Restrictions.like("description", description));
		List results = cr.list();

		System.out.println("Описание: " + " "+description);


		transaction.commit();
		session.close();

		return results;
	}
}
