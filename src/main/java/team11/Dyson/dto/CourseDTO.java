// CourseDTO.java
package team11.Dyson.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CourseDTO {

    private Integer id;
    private String title;
    private StaffDTO teacher;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String room;
    private String courseworkName;
    private LocalDateTime courseworkDeadline;
    private String courseworkDescription;
    private Integer modId;

    // Constructor, getters, and setters ...

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeacher(StaffDTO teacher) {
        this.teacher = teacher;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setCourseworkName(String courseworkName) {
        this.courseworkName = courseworkName;
    }

    public void setCourseworkDeadline(LocalDateTime courseworkDeadline) {
        this.courseworkDeadline = courseworkDeadline;
    }

    public void setCourseworkDescription(String courseworkDescription) {
        this.courseworkDescription = courseworkDescription;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }
}