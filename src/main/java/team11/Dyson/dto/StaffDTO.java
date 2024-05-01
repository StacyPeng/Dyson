// StaffDTO.java
package team11.Dyson.dto;

public class StaffDTO {

    private String email;
    // 可以包含其他需要的Staff信息，但不包含教授的课程列表

    // 这里是 email 属性的 getter 方法
    public String getEmail() {
        return email;
    }

    // 这里是 email 属性的 setter 方法
    public void setEmail(String email) {
        this.email = email;
    }

    // Constructor, getters, and setters ...
}