package service;

import vo.CourseUserVO;

import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public interface HomeService {
    public ArrayList<CourseUserVO> testData();
    public ArrayList<CourseUserVO> getUserCourses(int user_id);
}
