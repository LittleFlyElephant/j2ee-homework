package model;

import javax.persistence.*;

/**
 * Created by raychen on 2017/2/23.
 */
@Entity
@Table(name = "tb_courses_select", schema = "j2eeDB1", catalog = "")
public class TbCoursesSelect {
    private int id;
    private int courseId;
    private int userId;
    private Integer score;
    private Byte absent;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "score", nullable = true)
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "absent", nullable = true)
    public Byte getAbsent() {
        return absent;
    }

    public void setAbsent(Byte absent) {
        this.absent = absent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbCoursesSelect that = (TbCoursesSelect) o;

        if (id != that.id) return false;
        if (courseId != that.courseId) return false;
        if (userId != that.userId) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (absent != null ? !absent.equals(that.absent) : that.absent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + courseId;
        result = 31 * result + userId;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (absent != null ? absent.hashCode() : 0);
        return result;
    }
}
