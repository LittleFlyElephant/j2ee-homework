package service.impl;

import dao.UserDAO;
import model.TbStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.LoginService;

/**
 * Created by raychen on 2017/1/1.
 */
@Service
public class LoginSerivceImpl implements LoginService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public TbStudents getUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }
}
