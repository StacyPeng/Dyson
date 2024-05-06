
//Auther：Hengqian Mao
package team11.Dyson.domian;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "staff_email_address")
    private String staffEmailAddress;

    private String staName;
    private String password;
    private String gender;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)  // 确保这里使用的是 TemporalType.DATE
    private Date birthday;

    // 与课程的一对多关系
    @OneToMany(mappedBy = "teacher") // 'teacher' 必须与 Course 类中的 Staff 属性名匹配
    private Set<Course> coursesTaught;


    public Staff() {
    }

    public Staff(String staffEmailAddress, String staName, String password, String gender, Timestamp birthday) {
        this.staffEmailAddress = staffEmailAddress;
        this.staName = staName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }

    public Staff(String staffEmailAddress, String staName, String password, String gender, Date birthday, Set<Course> coursesTaught) {
        this.staffEmailAddress = staffEmailAddress;
        this.staName = staName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.coursesTaught = coursesTaught;
    }

    public String getStaffEmailAddress() {
        return staffEmailAddress;
    }

    public void setStaffEmailAddress(String staffEmailAddress) {
        this.staffEmailAddress = staffEmailAddress;
    }

    public String getStaName() {
        return staName;
    }

    public void setStaName(String staName) {
        this.staName = staName;
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

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Set<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public String toString() {
        return "Staff{staffEmailAddress = " + staffEmailAddress + ", staName = " + staName + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", coursesTaught = " + coursesTaught + "}";
    }
}

