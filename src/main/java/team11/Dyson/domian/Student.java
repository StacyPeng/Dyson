package team11.Dyson.domian;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_email_address", nullable = false)
    private String studentEmailAddress;

    @Column(name = "stu_name")
    private String stuName;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "class_id")
    private Integer classId;

    /*@ManyToMany(mappedBy = "students")
    private Set<Course> coursesEnrolled;*/

    public Student() {
    }

    public Student(String studentEmailAddress, String stuName, String password, String gender, Date birthday, Integer classId/*, Set<Course> coursesEnrolled*/) {
        this.studentEmailAddress = studentEmailAddress;
        this.stuName = stuName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.classId = classId;
        /*this.coursesEnrolled = coursesEnrolled;*/
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /*public Set<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }*/

    /*public void setCoursesEnrolled(Set<Course> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }*/

    /*public String toString() {
        return "Student{studentEmailAddress = " + studentEmailAddress + ", stuName = " + stuName + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", classId = " + classId + ", coursesEnrolled = " + coursesEnrolled + "}";
    }*/

    // 构造函数、getter和setter
    // ...


}
