package team11.Dyson.domian;

import java.sql.Timestamp;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class Coursework {
    private String courseworkName;
    private Timestamp courseworkDeadline;
    private String coursework_description;
    private Integer modId;

    public Coursework() {
    }

    public Coursework(String courseworkName, Timestamp courseworkDeadline, String coursework_description, Integer modId) {
        this.courseworkName = courseworkName;
        this.courseworkDeadline = courseworkDeadline;
        this.coursework_description = coursework_description;
        this.modId = modId;
    }

    public String getCourseworkName() {
        return courseworkName;
    }

    public void setCourseworkName(String courseworkName) {
        this.courseworkName = courseworkName;
    }

    public Timestamp getCourseworkDeadline() {
        return courseworkDeadline;
    }

    public void setCourseworkDeadline(Timestamp courseworkDeadline) {
        this.courseworkDeadline = courseworkDeadline;
    }


    public String getCoursework_description() {
        return coursework_description;
    }

    public void setCoursework_description(String coursework_description) {
        this.coursework_description = coursework_description;
    }


    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String toString() {
        return "Coursework{courseworkName = " + courseworkName + ", courseworkDeadline = " + courseworkDeadline + ", coursework_description = " + coursework_description + ", modId = " + modId + "}";
    }
}
