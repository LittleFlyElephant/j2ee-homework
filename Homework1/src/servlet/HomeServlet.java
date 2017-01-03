package servlet;

import model.CourseSelectModel;
import model.UserModel;
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
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ServletContext context = getServletContext();
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if (session == null || session.getAttribute("username") == null){
            out.println("<html>");
            out.println("<head><title>Vistor</title></head>");
            out.println("<body>");
            out.println("<h1>Vistor page</h1>");
            out.println("<form method=\"post\" action=\"/home\">");
            out.println("<input type=\"submit\" name=\"login\" value=\"返回登录\">");
            out.println("</form>");
        } else {
            String username = (String) session.getAttribute("username");
            Result res = UserModel.queryUser(username);
            String title = "Normal";
            MessageState pageState = MessageState.SUCCESS;
            ArrayList<Integer> scores = new ArrayList<>();
            UserModel user = null;
            if (res.state == MessageState.SUCCESS){
                //存在用户,查询课程得分
                user = (UserModel) res.value;
                for (Integer course_id: user.courses) {
                    Result course_res = CourseSelectModel.queryScore(user.user_id, course_id);
                    if (course_res.state == MessageState.NOT_PART_IN){
                        pageState = MessageState.NOT_PART_IN;
                        title = "Warning!";
                    }
                    scores.add((Integer) course_res.value);
                }
            } else if (res.state == MessageState.UNKNOWN_USER){
                //未知ID
                title = "Unknown Id!";
                pageState = MessageState.UNKNOWN_USER;
            }
            //输出
            out.println("<html>");
            out.println("<head><title>"+title+"</title></head>");
            out.println("<body>");
            if (pageState == MessageState.UNKNOWN_USER){
                out.println("<h1>未知用户ID:"+ username+ "</h1>");
            } else {
                if (pageState == MessageState.NOT_PART_IN){
                    out.println("<h1>Warning! 你有未参加的考试!</h1>");
                }
                for (int i=0;i<user.courses.size();i++) {
                    out.println("<p>课程:"+user.courses.get(i)+"&nbsp;&nbsp;得分:"+scores.get(i)+"</p>");
                }
            }
            out.println("<form method=\"post\" action=\"/home\">");
            out.println("<input type=\"submit\" name=\"logout\" value=\"注销\">");
            out.println("</form>");
        }
        out.println("<p>游客数量: "+context.getAttribute("visitor_count")+"</p>");
        out.println("<p>登录用户数量: "+context.getAttribute("login_count")+"</p>");
        out.println("<p>总在线数量: "+(Integer.parseInt((String)context.getAttribute("visitor_count"))
                +Integer.parseInt((String)context.getAttribute("login_count")))+"</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ServletContext context = getServletContext();
        if (req.getParameter("logout") != null){
            System.out.println("注销会话");
            session.invalidate();
            session = null;
            ServletUtil.decContext(context, "login_count");
            resp.sendRedirect("/login");
        } else if (req.getParameter("login") != null){
            ServletUtil.decContext(context, "visitor_count");
            resp.sendRedirect("/login");
        }else {
            resp.sendRedirect("/home");
        }
    }
}
