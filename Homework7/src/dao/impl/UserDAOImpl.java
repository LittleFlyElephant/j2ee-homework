package dao.impl;

import dao.UserDAO;
import model.TbStudents;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 * Created by raychen on 2016/12/30.
 */
public class UserDAOImpl implements UserDAO {
    private Session session;

    @Override
    public TbStudents findUserByUsername(String username) {
        session = HibernateUtil.getSession();
        String hql = "from TbStudents u where u.username = ?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, username);
        TbStudents students = (TbStudents) query.getSingleResult();
        return students;
    }
}
