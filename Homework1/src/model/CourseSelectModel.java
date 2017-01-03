package model;

import util.DBHelper;
import util.MessageState;
import util.Result;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by raychen on 2016/12/19.
 */
public class CourseSelectModel {

    private static DBHelper dbhelper = DBHelper.getInstance();

    public static Result queryScore(int user_id, int course_id){
        String sql = "select score from tb_courses_select where course_id="+course_id+" and user_id="+user_id;
        ResultSet rs = dbhelper.query(sql);
        String msg = "没有选择该课程";
        MessageState state = MessageState.NOT_SELECT;
        int score = -1;
        try {
            while (rs.next()){
                msg = "成功获得所选课程分数!";
                state = MessageState.SUCCESS;
                score = rs.getInt("score");
                if (score < 0){
                    state = MessageState.NOT_PART_IN;
                    msg = "未参加测验";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Result res = new Result(msg, state, score);
        return res;
    }

}
