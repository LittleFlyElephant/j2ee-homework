package dao;

import model.CourseSelect;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raychen on 2016/12/30.
 */
@Remote
public interface CourseSelectDAO {
    public List<CourseSelect> findByUserId(int user_id);
}
