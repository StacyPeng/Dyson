package team11.Dyson.dto;
//Auther：Hengqian Mao
//c3008838
public class SubscriptionRequest {
    private Integer courseId;
    private String email;

    // Getters and setters
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
