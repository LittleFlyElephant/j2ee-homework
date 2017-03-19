package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by raychen on 2016/12/30.
 */
@Entity
@Table(name = "tb_courses_select")
public class CourseSelect implements Serializable {
    private int course_id;
    private int user_id;
    private Integer score;
    private Integer absent;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }

    public Integer getAbsent() {
        return absent;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Integer getScore() {
        return score;
    }

    public void setAbsent(Integer absent) {
        this.absent = absent;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
