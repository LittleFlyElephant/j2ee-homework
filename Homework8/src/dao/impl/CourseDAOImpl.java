package dao.impl;

import dao.BaseDAO;
import dao.CourseDAO;
import model.TbCourses;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

/**
 * Created by raychen on 2016/12/30.
 */
@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    private BaseDAO baseDAO;

    @Override
    public TbCourses findById(int id) {
        TbCourses course = (TbCourses) baseDAO.load(TbCourses.class, id);
//        String hql = "from TbCourses as c where c.id = ?1";
//        Query query = session.createQuery(hql);
//        query.setParameter(1, id);
//        TbCourses courses = (TbCourses) query.getSingleResult();
        return course;
    }
}
