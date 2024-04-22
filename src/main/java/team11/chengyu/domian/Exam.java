package team11.chengyu.domian;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class Exam {
    private Integer examId;
    private String examName;
    private Timestamp examTime;
    private String place;
    private Integer modId;


    public Exam() {
    }

    public Exam(Integer examId, String examName, Timestamp examTime, String place, Integer modId) {
        this.examId = examId;
        this.examName = examName;
        this.examTime = examTime;
        this.place = place;
        this.modId = modId;
    }

    /**
     * 获取
     * @return examId
     */
    public Integer getExamId() {
        return examId;
    }

    /**
     * 设置
     * @param examId
     */
    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    /**
     * 获取
     * @return examName
     */
    public String getExamName() {
        return examName;
    }

    /**
     * 设置
     * @param examName
     */
    public void setExamName(String examName) {
        this.examName = examName;
    }

    /**
     * 获取
     * @return examTime
     */
    public Timestamp getExamTime() {
        return examTime;
    }

    /**
     * 设置
     * @param examTime
     */
    public void setExamTime(Timestamp examTime) {
        this.examTime = examTime;
    }

    /**
     * 获取
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设置
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
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
        return "Exam{examId = " + examId + ", examName = " + examName + ", examTime = " + examTime + ", place = " + place + ", modId = " + modId + "}";
    }
}
