package team11.Dyson.domain;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */

import java.sql.Timestamp;

public class Exam {
    private Integer examId;
    private String examName;
    private Timestamp examTime;
    private String place;
    private Integer modId;
    //考试成绩 llh
    private String achievement;



    public Exam() {
    }

    public Exam(Integer examId, String examName, Timestamp examTime, String place, Integer modId,String achievement) {
        this.examId = examId;
        this.examName = examName;
        this.examTime = examTime;
        this.place = place;
        this.modId = modId;
        this.achievement = achievement;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Timestamp getExamTime() {
        return examTime;
    }

    public void setExamTime(Timestamp examTime) {
        this.examTime = examTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public String toString() {
        return "Exam{examId = " + examId + ", examName = " + examName + ", examTime = " + examTime + ", place = " + place + ", modId = " + modId + "}";
    }
}
