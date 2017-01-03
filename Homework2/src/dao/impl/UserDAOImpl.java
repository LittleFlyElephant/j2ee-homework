package dao.impl;

import dao.DAOHelper;
import dao.UserDAO;
import model.User;

import java.sql.*;

/**
 * Created by raychen on 2016/12/30.
 */
public class UserDAOImpl implements UserDAO{
    private static DAOHelper helper = DAOHelperImpl.getInstance();

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
