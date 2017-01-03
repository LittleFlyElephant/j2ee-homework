package model;

import util.DBHelper;
import util.MessageState;
import util.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by raychen on 2016/12/19.
 */
public class UserModel {
    public int user_id;
    public String username;
    public ArrayList<Integer> courses;
    private static DBHelper dbHelper = DBHelper.getInstance();

    public static Result queryUser(String username){
        String sql = "select * from tb_students where username='"+username+"'";
        ResultSet rs = dbHelper.query(sql);
        MessageState state = MessageState.UNKNOWN_USER;
        String msg = "没有该用户";
        UserModel model = null;
        try {
            while (rs.next()){
                state = MessageState.SUCCESS;
                msg = "成功获得用户!";
                model = new UserModel();
                model.user_id = rs.getInt("id");
                model.username = username;
                ArrayList<Integer> courses = new ArrayList<>();
                sql = "select * from tb_courses_select where user_id="+rs.getInt("id");
                ResultSet rs2 = dbHelper.query(sql);
                while (rs2.next()){
                    courses.add(rs2.getInt("course_id"));
                }
                model.courses = courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Result(msg, state, model);
    }
}
