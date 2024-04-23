package team11.chengyu.domian;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class Student {
    private String student_email_address;
    private String stuName;
    private String password;
    private String gender;
    private Date birthday;
    private Integer class_id;


    public Student() {
    }

    public Student(String student_email_address, String stuName, String password, String gender, Date birthday, Integer class_id) {
        this.student_email_address = student_email_address;
        this.stuName = stuName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.class_id = class_id;
    }

    /**
     * 获取
     * @return student_email_address
     */
    public String getStudent_email_address() {
        return student_email_address;
    }

    /**
     * 设置
     * @param student_email_address
     */
    public void setStudent_email_address(String student_email_address) {
        this.student_email_address = student_email_address;
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
     * @return class_id
     */
    public Integer getClass_id() {
        return class_id;
    }

    /**
     * 设置
     * @param class_id
     */
    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String toString() {
        return "Student{student_email_address = " + student_email_address + ", stuName = " + stuName + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", class_id = " + class_id + "}";
    }
}
