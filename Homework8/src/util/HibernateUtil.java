package util;

import model.TbCourses;
import model.TbCoursesSelect;
import model.TbStudents;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by raychen on 2017/2/23.
 */
public class HibernateUtil {

    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory serviceFactory;
    private static Session session;

    public static Session getSession(){
        if (session == null){
            configuration = new Configuration().configure();
            configuration.addAnnotatedClass(TbStudents.class);
            configuration.addAnnotatedClass(TbCourses.class);
            configuration.addAnnotatedClass(TbCoursesSelect.class);
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            serviceFactory = configuration.buildSessionFactory(serviceRegistry);
            session = serviceFactory.openSession();
        }
        return session;
    }

    public static void closeSession(){
        session.close();
    }
}
