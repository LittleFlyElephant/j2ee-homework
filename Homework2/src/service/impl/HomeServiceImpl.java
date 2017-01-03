package service.impl;

import dao.CourseDAO;
import dao.CourseSelectDAO;
import factory.DAOFactory;
import model.Course;
import model.CourseSelect;
import service.HomeService;
import vo.CourseUserVO;

import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public class HomeServiceImpl implements HomeService {

    private DAOFactory factory = DAOFactory.getInstance();
    private CourseSelectDAO courseSelectDAO;
    private CourseDAO courseDAO;

    public HomeServiceImpl(){
        courseSelectDAO = factory.getCourseSelectDAO();
        courseDAO = factory.getCourseDAO();
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
