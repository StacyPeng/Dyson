
//Auther：Hengqian Mao
//c3008838
package team11.Dyson.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer id;

    @Column(name = "class_name")
    private String title;

    @ManyToOne
    @JoinColumn(name = "staff_email_address")
    private Staff teacher;

    @Column(name = "class_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
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
    private Integer modId;

    @ManyToMany
    @JoinTable(
            name = "stu_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_email_address")
    )
    private Set<Student> students;

    //  getters  setters ...

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
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
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

