package servlet;

import factory.ServiceFactory;
import model.User;
import service.LoginService;
import util.ServletUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by raychen on 2016/12/11.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    private ServiceFactory factory = ServiceFactory.getInstance();
    private LoginService loginService;

    public LoginServlet() {
        super();
        loginService = factory.getLoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        context.getRequestDispatcher("/jsp/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = req.getSession(true);
        if (req.getParameter("login") != null){
            String username = req.getParameter("username");
            User user = loginService.getUserByUsername(username);
            if (user != null){
                session.setAttribute("username", user.getUsername());
                session.setAttribute("user_id", user.getId());
                ServletUtil.addContext(context, "login_count");
                resp.sendRedirect("/home");
            } else {
                session.setAttribute("error_message", "User not found!");
                context.getRequestDispatcher("/jsp/Error.jsp").forward(req, resp);
            }
        } else if (req.getParameter("visit") != null){
            ServletUtil.addContext(context, "visitor_count");
            session.setAttribute("visitor", 1);
            resp.sendRedirect("/home");
        }
    }
}
