package dao.impl;

import dao.BaseDAO;
import dao.UserDAO;
import model.TbStudents;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by raychen on 2016/12/30.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private BaseDAO baseDAO;

    @Override
    public TbStudents findUserByUsername(String username) {
        Session session = baseDAO.getSession();
        String hql = "from TbStudents u where u.username = ?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, username);
        TbStudents students = (TbStudents) query.getSingleResult();
        return students;
    }
}
