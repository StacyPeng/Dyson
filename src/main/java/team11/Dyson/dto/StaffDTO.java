package team11.Dyson.dto;

import java.util.Date;
import java.util.Set;

public class StaffDTO {

    private String email;
    private String name;
    private String gender;
    private Date birthday;

    private Set<Integer> coursesTaughtIds;

    // Constructors, getters and setters
    public StaffDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Integer> getCoursesTaughtIds() {
        return coursesTaughtIds;
    }

    public void setCoursesTaughtIds(Set<Integer> coursesTaughtIds) {
        this.coursesTaughtIds = coursesTaughtIds;
    }
}
