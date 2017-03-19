package dao;

import model.TbStudents;

/**
 * Created by raychen on 2016/12/30.
 */
public interface UserDAO {
    public TbStudents findUserByUsername(String username);
}
