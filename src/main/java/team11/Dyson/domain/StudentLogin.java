package team11.Dyson.domain;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 22:48
 * @student ID:230045675
 */
public class StudentLogin {
    private String studentEmailAddress;
    private String studentPassword;


    public StudentLogin() {
    }

    public StudentLogin(String studentEmailAddress, String studentPassword) {
        this.studentEmailAddress = studentEmailAddress;
        this.studentPassword = studentPassword;
    }

    public String getStudentEmailAddress() {
        return studentEmailAddress;
    }

    public void setStudentEmailAddress(String studentEmailAddress) {
        this.studentEmailAddress = studentEmailAddress;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String toString() {
        return "StudentLogin{studentEmailAddress = " + studentEmailAddress + ", studentPassword = " + studentPassword + "}";
    }
}
