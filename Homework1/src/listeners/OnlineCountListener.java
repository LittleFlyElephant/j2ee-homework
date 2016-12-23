package listeners;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by raychen on 2016/12/19.
 */
@WebListener
public class OnlineCountListener implements ServletContextListener, ServletContextAttributeListener {

    private int counter_vistor;
    private int counter_login;
    private String filePath = "/Users/raychen/D/github/j2ee-homework/Homework1/web/counter.txt";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            counter_login = Integer.parseInt( reader.readLine() );
            counter_vistor = Integer.parseInt( reader.readLine() );
            reader.close();
            }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        ServletContext servletContext= sce.getServletContext();
        servletContext.setAttribute("visitor_count", Integer.toString(counter_vistor));
        servletContext.setAttribute("login_count", Integer.toString(counter_login));
        System.out.println("Application initialized");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("ServletContextattribute added");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("ServletContextattribute replaced");
        writeCounter(scae.getServletContext());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("ServletContextattribute removed");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext= sce.getServletContext();
        servletContext.setAttribute("visitor_count", "0");
        servletContext.setAttribute("login_count", "0");
        writeCounter(sce.getServletContext());
        System.out.println("Application shut down");
    }

    synchronized void writeCounter(ServletContext servletContext) {
        counter_vistor = Integer.parseInt((String) servletContext.getAttribute("visitor_count"));
        counter_login = Integer.parseInt((String) servletContext.getAttribute("login_count"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(Integer.toString(counter_vistor));
            writer.newLine();
            writer.write(Integer.toString(counter_login));
            writer.close();
            System.out.println("Writing");
        }catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
