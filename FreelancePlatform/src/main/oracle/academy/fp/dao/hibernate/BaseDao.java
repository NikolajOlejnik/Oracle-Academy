package main.oracle.academy.fp.dao.hibernate;


import main.oracle.academy.fp.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

abstract class BaseDao <Entity> implements Dao <Entity> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class <Entity> persistentClass;

    public BaseDao() {
        this.persistentClass = (Class<Entity>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }


    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(Entity object) {
        getSession().save(object);
    }

    @Override
    public Entity read (Long id) {
        return (Entity) getSession().get(persistentClass, id);
    }

    @Override
    public void update(Entity o) {
        Session session = getSession();
        session.update(o);
        session.flush();
    }

    @Override
    public void delete(Long id) {
        Session session = getSession();
        session.delete(session.load(persistentClass, id));
    }

    @Override
    public Collection <Entity> getAll() {
        return getSession().createCriteria(persistentClass).list();
    }
}
