package dao.impl;

import dao.BaseDAO;
import dao.CourseSelectDAO;
import model.TbCoursesSelect;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;
import java.util.List;

/**
 * Created by raychen on 2016/12/30.
 */
@Repository
@Transactional
public class CourseSelectDAOImpl implements CourseSelectDAO {

    @Autowired
    private BaseDAO baseDAO;

    @Override
    public List<TbCoursesSelect> findByUserId(int user_id) {
        Session session = baseDAO.getSession();
        String hql = "from TbCoursesSelect cs where cs.userId = ?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, user_id);
        return query.list();
    }
}
