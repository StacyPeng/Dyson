package team11.Dyson.domian;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/6 下午2:57
 * @student ID:230045675
 */
public class Register {
    private String emailAddress;
    private String name;
    private String password;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Integer classId;


    public Register() {
    }

    public Register(String emailAddress, String name, String password, String gender, Date birthday) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return "Register{emailAddress = " + emailAddress + ", name = " + name + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", classId = " + classId + "}";
    }
}
