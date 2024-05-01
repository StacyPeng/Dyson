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

    /**
     * 获取
     * @return courseworkName
     */
    public String getCourseworkName() {
        return courseworkName;
    }

    /**
     * 设置
     * @param courseworkName
     */
    public void setCourseworkName(String courseworkName) {
        this.courseworkName = courseworkName;
    }

    /**
     * 获取
     * @return courseworkDeadline
     */
    public Timestamp getCourseworkDeadline() {
        return courseworkDeadline;
    }

    /**
     * 设置
     * @param courseworkDeadline
     */
    public void setCourseworkDeadline(Timestamp courseworkDeadline) {
        this.courseworkDeadline = courseworkDeadline;
    }

    /**
     * 获取
     * @return coursework_description
     */
    public String getCoursework_description() {
        return coursework_description;
    }

    /**
     * 设置
     * @param coursework_description
     */
    public void setCoursework_description(String coursework_description) {
        this.coursework_description = coursework_description;
    }

    /**
     * 获取
     * @return modId
     */
    public Integer getModId() {
        return modId;
    }

    /**
     * 设置
     * @param modId
     */
    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String toString() {
        return "Coursework{courseworkName = " + courseworkName + ", courseworkDeadline = " + courseworkDeadline + ", coursework_description = " + coursework_description + ", modId = " + modId + "}";
    }
}
