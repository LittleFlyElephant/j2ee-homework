package dao;

import model.User;

import javax.ejb.Remote;

/**
 * Created by raychen on 2016/12/30.
 */
@Remote
public interface UserDAO {
    public User findUserByUsername(String username);
}
