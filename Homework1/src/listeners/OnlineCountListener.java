package listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by raychen on 2016/12/19.
 */
@WebListener
public class OnlineCountListener implements ServletContextListener, ServletContextAttributeListener {

    private int counter;
    private String filePath = "../../../counter.txt";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            counter = Integer.parseInt( reader.readLine() );
            reader.close();
            System.out.println("Reading" + counter);}
        catch (Exception e) {
            System.out.println(e.toString());
        }
        ServletContext servletContext= sce.getServletContext();
        servletContext.setAttribute("pageCounter", Integer.toString(counter));
        System.out.println("Application initialized");
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
