package service;

import model.User;

/**
 * Created by raychen on 2017/1/1.
 */
public interface LoginService {
    public User getUserByUsername(String username);
}
