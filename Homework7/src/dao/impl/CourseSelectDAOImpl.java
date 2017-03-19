package dao.impl;

import dao.CourseSelectDAO;
import model.TbCoursesSelect;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;
import java.util.List;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseSelectDAOImpl implements CourseSelectDAO {

    private Session session;

    @Override
    public List<TbCoursesSelect> findByUserId(int user_id) {
        session = HibernateUtil.getSession();
        String hql = "from TbCoursesSelect cs where cs.userId = ?1";
        Query query = session.createQuery(hql);
        query.setParameter(1, user_id);
        return query.list();
    }
}
