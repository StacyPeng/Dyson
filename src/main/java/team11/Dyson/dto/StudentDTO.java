package team11.Dyson.dto;

public class StudentDTO {
    private String studentEmailAddress;
    private Integer courseId;

    public StudentDTO() {
    }

    public StudentDTO(String studentEmailAddress, Integer courseId) {
        this.studentEmailAddress = studentEmailAddress;
        this.courseId = courseId;
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
