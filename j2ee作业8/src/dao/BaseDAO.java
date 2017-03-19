package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by raychen on 2017/3/18.
 */
public interface BaseDAO {
    public Session getSession();

    public Session getNewSession();

    public void flush();

    public void clear() ;

    public Object load(Class c, Integer id) ;

    public void save(Object bean) ;

    public void update(Object bean) ;

    public void delete(Object bean) ;

}
