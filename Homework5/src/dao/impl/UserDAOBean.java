package dao.impl;

import dao.DAOHelper;
import dao.UserDAO;
import model.User;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raychen on 2017/2/21.
 */
@Stateless(name = "UserDAOEJB")
public class UserDAOBean implements UserDAO{
    private static DAOHelper helper = DAOHelperImpl.getInstance();
    public UserDAOBean() {
    }

    private User getFromSingleRs(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setPermission(rs.getInt("permission"));
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = conn.prepareStatement("SELECT * FROM tb_students WHERE username=?");
            stat.setString(1, username);
            rs = stat.executeQuery();
            if (rs.next()){
                user = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return user;
    }
}
