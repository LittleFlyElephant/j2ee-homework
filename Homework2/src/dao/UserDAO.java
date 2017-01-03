package dao;

import model.User;

/**
 * Created by raychen on 2016/12/30.
 */
public interface UserDAO {
    public User findUserByUsername(String username);
}
