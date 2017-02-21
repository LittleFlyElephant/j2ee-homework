package service.impl;

import dao.UserDAO;
import factory.EJBFactory;
import model.User;
import service.LoginService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "LoginServiceEJB")
public class LoginServiceBean implements LoginService{
    @EJB
    UserDAO userDAO;
//    UserDAO userDao = (UserDAO) EJBFactory
//            .getEJB("ejb:/Homework5_war_exploded//UserDAOEJB!"+UserDAO.class.getName());
    public LoginServiceBean() {
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }
}
