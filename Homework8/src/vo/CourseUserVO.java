package vo;

import java.io.Serializable;

/**
 * Created by raychen on 2016/12/30.
 */
public class CourseUserVO implements Serializable {
    private String course_name;
    private int course_id;
    private int score;
    private String state;


    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourse_name() {
        return course_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getScore() {
        return score;
    }
}
