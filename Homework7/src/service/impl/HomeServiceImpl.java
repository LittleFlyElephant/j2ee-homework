package service.impl;

import dao.CourseDAO;
import dao.CourseSelectDAO;
import factory.DAOFactory;
import model.TbCourses;
import model.TbCoursesSelect;
import service.HomeService;
import vo.CourseUserVO;

import java.util.ArrayList;
import java.util.List;

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
        List<TbCoursesSelect> courseSelects = courseSelectDAO.findByUserId(user_id);
        for (TbCoursesSelect courseSelect: courseSelects) {
            TbCourses course = courseDAO.findById(courseSelect.getCourseId());
            CourseUserVO vo = new CourseUserVO();
            vo.setCourse_id(course.getId());
            vo.setCourse_name(course.getCourseName());
            vo.setScore(courseSelect.getScore()==null?-1:courseSelect.getScore());
            if (courseSelect.getAbsent() == 1) vo.setState("缺考");
            else vo.setState("正常");
            vos.add(vo);
        }
        return vos;
    }
}
