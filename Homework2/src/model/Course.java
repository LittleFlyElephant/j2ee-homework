package model;

import java.io.Serializable;

/**
 * Created by raychen on 2016/12/30.
 */
public class Course implements Serializable {
    private int id;
    private String course_name;

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public String getCourse_name() {
        return course_name;
    }
}
