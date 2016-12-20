package listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by raychen on 2016/12/19.
 */
@WebListener
public class OnlineCountListener implements ServletContextListener, ServletContextAttributeListener {

    private int counter;
    private String filePath = "";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
