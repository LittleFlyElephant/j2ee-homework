package dao;

import model.TbCoursesSelect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raychen on 2016/12/30.
 */
public interface CourseSelectDAO {
    public List<TbCoursesSelect> findByUserId(int user_id);
}
