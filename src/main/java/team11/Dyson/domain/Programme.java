package team11.Dyson.domain;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 13:16
 * @student ID:230045675
 */
public class Programme {
    private Integer proId;
    private String proName;
    private String Description;
    private String student_email_address;

    public Programme() {
    }

    public Programme(Integer proId, String proName, String Description, String student_email_address) {
        this.proId = proId;
        this.proName = proName;
        this.Description = Description;
        this.student_email_address = student_email_address;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStudent_email_address() {
        return student_email_address;
    }

    public void setStudent_email_address(String student_email_address) {
        this.student_email_address = student_email_address;
    }

    public String toString() {
        return "Programme{proId = " + proId + ", proName = " + proName + ", Description = " + Description + ", student_email_address = " + student_email_address + "}";
    }
}
