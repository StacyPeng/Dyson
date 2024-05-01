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

    /**
     * 获取
     * @return studentEmailAddress
     */
    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    /**
     * 设置
     * @param studentEmailAddress
     */
    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    /**
     * 获取
     * @return stuName
     */
    public String getStuName() {
        return stuName;
    }

    /**
     * 设置
     * @param stuName
     */
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return classId
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取
     * @return coursesEnrolled
     */
    /*public Set<Course> getCoursesEnrolled() {
        return coursesEnrolled;
    }*/

    /**
     * 设置
     * @param /*coursesEnrolled
//     */
    /*public void setCoursesEnrolled(Set<Course> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }*/

    /*public String toString() {
        return "Student{studentEmailAddress = " + studentEmailAddress + ", stuName = " + stuName + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", classId = " + classId + ", coursesEnrolled = " + coursesEnrolled + "}";
    }*/

    // 构造函数、getter和setter
    // ...


}
