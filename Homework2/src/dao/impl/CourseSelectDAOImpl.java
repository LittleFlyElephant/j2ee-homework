package dao.impl;

import dao.CourseSelectDAO;
import dao.DAOHelper;
import model.CourseSelect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseSelectDAOImpl implements CourseSelectDAO{

    private static DAOHelper helper = DAOHelperImpl.getInstance();

    private CourseSelect getFromSingleRs(ResultSet rs) throws SQLException {
        CourseSelect courseSelect = new CourseSelect();
        courseSelect.setUser_id(rs.getInt("user_id"));
        courseSelect.setCourse_id(rs.getInt("course_id"));
        courseSelect.setScore(rs.getInt("score"));
        courseSelect.setAbsent(rs.getInt("absent"));
        return courseSelect;
    }

    @Override
    public ArrayList<CourseSelect> findByUserId(int user_id) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        ArrayList<CourseSelect> courseSelects = new ArrayList<>();
        try {
            stat = conn.prepareStatement("SELECT * FROM tb_courses_select WHERE user_id=?");
            stat.setInt(1, user_id);
            rs = stat.executeQuery();
            while (rs.next()){
                courseSelects.add(getFromSingleRs(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return courseSelects;
    }
}
