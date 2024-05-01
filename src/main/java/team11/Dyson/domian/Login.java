package team11.Dyson.domian;

public class Login {
    private String student_email_address;
    private String password;


    public Login() {
    }

    public Login(String student_email_address, String password) {
        this.student_email_address = student_email_address;
        this.password = password;
    }

    public String getStudent_email_address() {
        return student_email_address;
    }

    public void setStudent_email_address(String student_email_address) {
        this.student_email_address = student_email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Login{student_email_address = " + student_email_address + ", password = " + password + "}";
    }
}
