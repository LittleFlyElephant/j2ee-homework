package dao;

import model.CourseSelect;

import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public interface CourseSelectDAO {
    public ArrayList<CourseSelect> findByUserId(int user_id);
}
