package factory;

import dao.CourseDAO;
import dao.CourseSelectDAO;
import dao.UserDAO;
import dao.impl.CourseDAOImpl;
import dao.impl.CourseSelectDAOImpl;
import dao.impl.UserDAOImpl;

/**
 * Created by raychen on 2016/12/30.
 */
public class DAOFactory {
    private static DAOFactory factory = new DAOFactory();
    private DAOFactory(){}
    public static DAOFactory getInstance() {
        return factory;
    }

    public UserDAO getUserDAO(){
        return new UserDAOImpl();
    }

    public CourseSelectDAO getCourseSelectDAO(){
        return new CourseSelectDAOImpl();
    }

    public CourseDAO getCourseDAO() {
        return new CourseDAOImpl();
    }
}
