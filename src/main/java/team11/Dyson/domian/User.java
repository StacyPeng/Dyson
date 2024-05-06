package team11.Dyson.domian;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 23:43
 * @student ID:230045675
 */
public class User {
    private String emailAddress;
    private String password;
    private String identity;


    public User() {
    }

    public User(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User(String emailAddress, String password, String identity) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.identity = identity;
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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String toString() {
        return "Login{emailAddress = " + emailAddress + ", password = " + password + ", identity = " + identity + "}";
    }
}
