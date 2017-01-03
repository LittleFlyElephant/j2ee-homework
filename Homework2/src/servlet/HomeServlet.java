package servlet;

import factory.ServiceFactory;
import service.HomeService;
import service.impl.HomeServiceImpl;
import util.ServletUtil;
import util.Statistic;
import vo.CourseListVO;
import vo.CourseUserVO;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/11.
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private ServiceFactory factory = ServiceFactory.getInstance();
    private HomeService homeService;

    public HomeServlet() {
        super();
        homeService = factory.getHomeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ServletContext context = getServletContext();
        CourseListVO courseListVO = new CourseListVO();
        if (session.getAttribute("user_id") != null) {
            int user_id = (int) session.getAttribute("user_id");
            ArrayList<CourseUserVO> courseUserVOs = homeService.getUserCourses(user_id);
            courseListVO.setCourses(courseUserVOs);
        }
        session.setAttribute("courses", courseListVO);
        Statistic statistic = new Statistic();
        statistic.setLogin((String) context.getAttribute("login_count"));
        statistic.setVisitor((String) context.getAttribute("visitor_count"));
        session.setAttribute("state", statistic);
        context.getRequestDispatcher("/jsp/Home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        ServletContext context = getServletContext();
        if (req.getParameter("logout") != null) {
            System.out.println("注销会话");
            session.invalidate();
            session = null;
            ServletUtil.decContext(context, "login_count");
            resp.sendRedirect("/login");
        } else if (req.getParameter("login") != null) {
            ServletUtil.decContext(context, "visitor_count");
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("/home");
        }
    }
}
