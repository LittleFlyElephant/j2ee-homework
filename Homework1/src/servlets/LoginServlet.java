package servlets;

import models.CourseSelectModel;
import models.UserModel;
import util.MessageState;
import util.Result;

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
        out.println("<input type=\"submit\" value=\"登录\">");
        out.println("</form>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession(true);
        //不为空
        if (!username.equals("")){
            session.setAttribute("username", username);
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
