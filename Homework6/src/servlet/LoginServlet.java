package servlet;

import model.User;
import service.LoginService;
import util.Config;
import util.Result;
import util.ServletUtil;
import util.Statistic;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
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
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @EJB
    private LoginService loginService;

    public LoginServlet() {
        super();
//        loginService = (LoginService) EJBFactory.getEJB("ejb:/Homework5_war_exploded//LoginServiceEJB!"+LoginService.class.getName());
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
                resp.sendRedirect(Config.URL_ROOT+"/home");
            } else {
                Result res = new Result();
                res.setMessage("User not found!");
                session.setAttribute("res", res);
                context.getRequestDispatcher("/jsp/Error.jsp").forward(req, resp);
            }
        } else if (req.getParameter("visit") != null){
            ServletUtil.addContext(context, "visitor_count");
            Statistic statistic = new Statistic();
            statistic.setLogin((String) context.getAttribute("login_count"));
            statistic.setVisitor((String) context.getAttribute("visitor_count"));
            session.setAttribute("state", statistic);
            context.getRequestDispatcher("/jsp/Visitor.jsp").forward(req, resp);
        }
    }
}
