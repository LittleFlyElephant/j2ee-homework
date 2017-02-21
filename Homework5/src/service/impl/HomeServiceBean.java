package service.impl;

import dao.CourseDAO;
import dao.CourseSelectDAO;
import model.Course;
import model.CourseSelect;
import service.HomeService;
import vo.CourseUserVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "HomeServiceEJB")
public class HomeServiceBean implements HomeService{

    @EJB
    private CourseSelectDAO courseSelectDAO;
    @EJB
    private CourseDAO courseDAO;

    public HomeServiceBean() {
    }

    @Override
    public ArrayList<CourseUserVO> testData() {
        return null;
    }

    @Override
    public ArrayList<CourseUserVO> getUserCourses(int user_id) {
        ArrayList<CourseUserVO> vos = new ArrayList<>();
        ArrayList<CourseSelect> courseSelects = courseSelectDAO.findByUserId(user_id);
        for (CourseSelect courseSelect: courseSelects) {
            Course course = courseDAO.findById(courseSelect.getCourse_id());
            CourseUserVO vo = new CourseUserVO();
            vo.setCourse_id(course.getId());
            vo.setCourse_name(course.getCourse_name());
            vo.setScore(courseSelect.getScore());
            if (courseSelect.getAbsent() == 1) vo.setState("缺考");
            else vo.setState("正常");
            vos.add(vo);
        }
        return vos;
    }
}
