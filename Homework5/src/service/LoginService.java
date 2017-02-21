package service;

import model.User;

import javax.ejb.Remote;

/**
 * Created by raychen on 2017/1/1.
 */
@Remote
public interface LoginService {
    public User getUserByUsername(String username);
}
