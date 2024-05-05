package team11.Dyson.domian;

import java.sql.Timestamp;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class Coursework {
    private String courseworkName;
    private Timestamp courseworkDeadline;
    private String courseworkDescription;
    private Integer modId;

    public Coursework() {
    }

    public Coursework(String courseworkName, Timestamp courseworkDeadline, String coursework_description, Integer modId) {
        this.courseworkName = courseworkName;
        this.courseworkDeadline = courseworkDeadline;
        this.courseworkDescription = coursework_description;
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


    public String getCourseworkDescription() {
        return courseworkDescription;
    }

    public void setCourseworkDescription(String courseworkDescription) {
        this.courseworkDescription = courseworkDescription;
    }


    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String toString() {
        return "Coursework{courseworkName = " + courseworkName + ", courseworkDeadline = " + courseworkDeadline + ", coursework_description = " + courseworkDescription + ", modId = " + modId + "}";
    }
}
