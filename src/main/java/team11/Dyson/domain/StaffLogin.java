package team11.Dyson.domain;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 22:48
 * @student ID:230045675
 */
public class StaffLogin {
    private String staffEmailAddress;
    private String staffPassword;


    public StaffLogin() {
    }

    public StaffLogin(String staffEmailAddress, String staffPassword) {
        this.staffEmailAddress = staffEmailAddress;
        this.staffPassword = staffPassword;
    }

    public String getStaffEmailAddress() {
        return staffEmailAddress;
    }

    public void setStaffEmailAddress(String staffEmailAddress) {
        this.staffEmailAddress = staffEmailAddress;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String toString() {
        return "StaffLogin{staffEmailAddress = " + staffEmailAddress + ", staffPassword = " + staffPassword + "}";
    }
}
