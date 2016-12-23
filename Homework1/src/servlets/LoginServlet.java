package servlets;

import models.CourseSelectModel;
import models.UserModel;
import util.MessageState;
import util.Result;
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
import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/11.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head><title>Login</title></head>");
        out.println("<body>");

        out.println("<h1>登录页面</h1>");
        out.println("<form method=\"post\" action=\"/login\">");
        out.println("<input type=\"text\" name=\"username\">");
        out.println("<input type=\"submit\" name=\"login\" value=\"登录\">");
        out.println("<input type=\"submit\" name=\"visit\" value=\"以游客访问\">");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        System.out.println("do post");
        if (req.getParameter("login") != null){
            System.out.println("login");
            String username = req.getParameter("username");
            HttpSession session = req.getSession(true);
            //不为空
            if (!username.equals("")){
                session.setAttribute("username", username);
                ServletUtil.addContext(context, "login_count");
                resp.sendRedirect("/home");
            } else {
                resp.sendRedirect("/login");
            }
        } else if (req.getParameter("visit") != null){
            System.out.println("visit");
            ServletUtil.addContext(context, "visitor_count");
            resp.sendRedirect("/home");
        }
    }
}
