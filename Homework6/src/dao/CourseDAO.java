package dao;

import model.Course;

import javax.ejb.Remote;

/**
 * Created by raychen on 2016/12/30.
 */
@Remote
public interface CourseDAO {
    public Course findById(int id);
}
