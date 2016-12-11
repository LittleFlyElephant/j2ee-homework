package user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by raychen on 2016/12/11.
 */
@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.sendRedirect("/login");
        } else {
            System.out.println(session.getAttribute("username"));
            resp.sendRedirect(req.getContextPath()+"/user/home.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (req.getParameter("logout") != null && session != null){
            System.out.println("注销会话");
            session.invalidate();
            session = null;
            resp.sendRedirect("/login");
        }
    }
}
