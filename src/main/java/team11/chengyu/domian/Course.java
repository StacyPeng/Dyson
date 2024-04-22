//Auther：Hengqian Mao
package team11.chengyu.domian;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "classes") // 确保类名与数据库表名一致
public class Course {

    @Id
    @Column(name = "class_id") // 确保字段名与数据库列名一致
    private Integer id;

    @Column(name = "class_name")
    private String title;

    @ManyToOne // 教师和课程之间的多对一关系
    @JoinColumn(name = "staff_email_address") // 这里指定外键列名，匹配 Staff 表的主键
    private Staff teacher;

    @Column(name = "class_time")
    private LocalDateTime startTime;

    @Column(name = "end_time") // 新添加的结束时间字段
    private LocalDateTime endTime;

    @Column(name = "room")
    private String room;

    @Column(name = "coursework_name")
    private String courseworkName;

    @Column(name = "coursework_deadline")
    private LocalDateTime courseworkDeadline;

    @Column(name = "coursework_description")
    private String courseworkDescription;

    @Column(name = "mod_Id")
    private Integer mod_Id;

    @ManyToMany // 学生和课程之间的多对多关系
    @JoinTable(
            name = "stu_class", // 指定连接表名
            joinColumns = @JoinColumn(name = "class_id"), // 指定此方的连接列名
            inverseJoinColumns = @JoinColumn(name = "student_email_address") // 指定对方的连接列名，匹配 Student 表的主键
    )
    private Set<Student> students;

    //  getters 和 setters ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Staff getTeacher() {
        return teacher;
    }

    public void setTeacher(Staff teacher) {
        this.teacher = teacher;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourseworkName() {
        return courseworkName;
    }

    public void setCourseworkName(String courseworkName) {
        this.courseworkName = courseworkName;
    }

    public LocalDateTime getCourseworkDeadline() {
        return courseworkDeadline;
    }

    public void setCourseworkDeadline(LocalDateTime courseworkDeadline) {
        this.courseworkDeadline = courseworkDeadline;
    }

    public Integer getModId() {
        return mod_Id;
    }

    public void setModId(Integer modId) {
        this.mod_Id = modId;
    }

    public String getCourseworkDescription() {
        return courseworkDescription;
    }

    public void setCourseworkDescription(String courseworkDescription) {
        this.courseworkDescription = courseworkDescription;
    }



    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
