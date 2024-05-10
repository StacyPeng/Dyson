package team11.Dyson.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

//Auther：Hengqian Mao
//c3008838
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


    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student() {
    }

    public Student(String studentEmailAddress, String stuName, String password, String gender, Date birthday/*, Set<Course> coursesEnrolled*/) {
        this.studentEmailAddress = studentEmailAddress;
        this.stuName = stuName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;

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



    // Get the student's course list
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentEmailAddress='" + studentEmailAddress + '\'' +
                ", stuName='" + stuName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", courses=" + courses +
                '}';
    }

    /*public Set<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }*/

    /*public void setCoursesEnrolled(Set<Course> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }*/




}
