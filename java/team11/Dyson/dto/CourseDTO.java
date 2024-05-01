// CourseDTO.java
package team11.Dyson.dto;

import java.time.LocalDateTime;

public class CourseDTO {

    private Integer id;
    private String title;
    private StaffDTO teacher; // 使用 StaffDTO 替代 Staff 实体
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String room;
    private String courseworkName;
    private LocalDateTime courseworkDeadline;
    private String courseworkDescription;
    private Integer modId;

    // Constructor, getters, and setters ...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StaffDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(StaffDTO teacher) {
        this.teacher = teacher;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourseworkName() {
        return courseworkName;
    }

    public void setCourseworkName(String courseworkName) {
        this.courseworkName = courseworkName;
    }

    public LocalDateTime getCourseworkDeadline() {
        return courseworkDeadline;
    }

    public void setCourseworkDeadline(LocalDateTime courseworkDeadline) {
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
}