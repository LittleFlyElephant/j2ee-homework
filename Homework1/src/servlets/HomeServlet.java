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
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null){
            resp.sendRedirect("/login");
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
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
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
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (req.getParameter("logout") != null){
            System.out.println("注销会话");
            session.invalidate();
            session = null;
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/home");
        }
    }
}
