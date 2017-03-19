package dao.impl;

import dao.CourseDAO;
import model.TbCourses;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseDAOImpl implements CourseDAO {

    private Session session;

    @Override
    public TbCourses findById(int id) {
        session = HibernateUtil.getSession();
        String hql = "from TbCourses as c where c.id = ?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, id);
        TbCourses courses = (TbCourses) query.getSingleResult();
        return courses;
    }
}
