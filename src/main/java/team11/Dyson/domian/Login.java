package team11.Dyson.domian;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 23:43
 * @student ID:230045675
 */
public class Login {
    private String emailAddress;
    private String password;


    public Login() {
    }

    public Login(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Login{emailAddress = " + emailAddress + ", password = " + password + "}";
    }
}
