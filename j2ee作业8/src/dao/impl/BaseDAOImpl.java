package dao.impl;

import dao.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by raychen on 2017/3/18.
 */
@Repository
@Transactional
public class BaseDAOImpl implements BaseDAO {

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }

    @Override
    public void save(Object bean) {
        getSession().save(bean);
    }

    @Override
    public Object load(Class c, Integer id) {
        return getSession().get(c, id);
    }

    @Override
    public void update(Object bean) {
        Session session = getNewSession();
        session.update(bean);
        session.flush();
        session.clear();
        session.close();
    }

    @Override
    public void delete(Object bean) {
        Session session = getNewSession();
        session.delete(bean);
        session.flush();
        session.clear();
        session.close();
    }
}
