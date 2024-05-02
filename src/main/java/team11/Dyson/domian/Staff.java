
//Auther：Hengqian Mao
package team11.Dyson.domian;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "staff_email_address")
    private String staff_email_address;

    private String staName;
    private String password;
    private String gender;
    private Timestamp birthday;

    // 与课程的一对多关系
    @OneToMany(mappedBy = "teacher") // 'teacher' 必须与 Course 类中的 Staff 属性名匹配
    private Set<Course> coursesTaught;


    public Staff() {
    }

    public Staff(String staff_email_address, String staName, String password, String gender, Timestamp birthday, Set<Course> coursesTaught) {
        this.staff_email_address = staff_email_address;
        this.staName = staName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.coursesTaught = coursesTaught;
    }

    public String getStaff_email_address() {
        return staff_email_address;
    }

    public void setStaff_email_address(String staff_email_address) {
        this.staff_email_address = staff_email_address;
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

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public Set<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(Set<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }

    public String toString() {
        return "Staff{staff_email_address = " + staff_email_address + ", staName = " + staName + ", password = " + password + ", gender = " + gender + ", birthday = " + birthday + ", coursesTaught = " + coursesTaught + "}";
    }
}

