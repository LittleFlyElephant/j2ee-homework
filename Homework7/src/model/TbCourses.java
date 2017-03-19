package model;

import javax.persistence.*;

/**
 * Created by raychen on 2017/2/23.
 */
@Entity
@Table(name = "tb_courses", schema = "j2eeDB1", catalog = "")
public class TbCourses {
    private int id;
    private String courseName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_name", nullable = false, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbCourses tbCourses = (TbCourses) o;

        if (id != tbCourses.id) return false;
        if (courseName != null ? !courseName.equals(tbCourses.courseName) : tbCourses.courseName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        return result;
    }
}
