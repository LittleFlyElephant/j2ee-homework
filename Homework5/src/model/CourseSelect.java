package model;

import java.io.Serializable;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseSelect implements Serializable {
    private int course_id;
    private int user_id;
    private int score;
    private int absent;

    public int getAbsent() {
        return absent;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getScore() {
        return score;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
