package dao.impl;

import dao.CourseSelectDAO;
import dao.DAOHelper;
import model.CourseSelect;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "CourseSelectDAOEJB")
public class CourseSelectDAOBean implements CourseSelectDAO {
    @PersistenceContext(unitName = "test")
    protected EntityManager em;

    public CourseSelectDAOBean() {
    }

    @Override
    public List<CourseSelect> findByUserId(int user_id) {
        Query query = em.createQuery("select cl from CourseSelect cl where cl.user_id=?1");
        query.setParameter(1, user_id);
        return query.getResultList();
    }
}
