package dao.impl;

import dao.CourseDAO;
import dao.DAOHelper;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseDAOImpl implements CourseDAO {
    private static DAOHelper helper = DAOHelperImpl.getInstance();

    private Course getFromSingleRs(ResultSet rs) throws SQLException {
        Course course = new Course();
        course.setCourse_name(rs.getString("course_name"));
        course.setId(rs.getInt("id"));
        return course;
    }

    @Override
    public Course findById(int id) {
        Connection conn = helper.getConnection();
        PreparedStatement stat = null;
        ResultSet rs = null;
        Course course = null;
        try {
            stat = conn.prepareStatement("SELECT * FROM tb_courses WHERE id=?");
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while (rs.next()){
                course = getFromSingleRs(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            helper.closeConnection(conn);
            helper.closePreparedStatement(stat);
            helper.closeResult(rs);
        }
        return course;
    }
}
