package service;

import model.TbStudents;

/**
 * Created by raychen on 2017/1/1.
 */
public interface LoginService {
    public TbStudents getUserByUsername(String username);
}
