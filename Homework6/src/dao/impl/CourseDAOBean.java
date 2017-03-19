package dao.impl;

import dao.CourseDAO;
import dao.DAOHelper;
import model.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "CourseDAOEJB")
public class CourseDAOBean implements CourseDAO {
    @PersistenceContext(unitName = "test")
    protected EntityManager em;

    public CourseDAOBean() {
    }

    @Override
    public Course findById(int id) {
        Query query = em.createQuery("select c from Course c where c.id=?1");
        query.setParameter(1, id);
        Course c = (Course) query.getSingleResult();
        return c;
    }
}
