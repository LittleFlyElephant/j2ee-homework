package dao.impl;

import dao.DAOHelper;
import dao.UserDAO;
import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "UserDAOEJB")
public class UserDAOBean implements UserDAO{
    @PersistenceContext(unitName = "test")
    protected EntityManager em;

    public UserDAOBean() {
    }

    @Override
    public User findUserByUsername(String username) {
        Query query = em.createQuery("select u from User u where u.username = ?1");
        query.setParameter(1, username);
        User u = (User) query.getSingleResult();
        return u;
    }
}
