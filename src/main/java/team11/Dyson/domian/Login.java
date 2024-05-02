package team11.Dyson.domian;

public class Login {
    private String student_email_address;
    private String password;
    private String staff_email_address;
    private String staff_password;


    public Login() {
    }

    public Login(String student_email_address, String password, String staff_email_address, String staff_password) {
        this.student_email_address = student_email_address;
        this.password = password;
        this.staff_email_address = staff_email_address;
        this.staff_password = staff_password;
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

    public String getStaff_email_address() {
        return staff_email_address;
    }

    public void setStaff_email_address(String staff_email_address) {
        this.staff_email_address = staff_email_address;
    }

    public String getStaff_password() {
        return staff_password;
    }

    public void setStaff_password(String staff_password) {
        this.staff_password = staff_password;
    }

    public String toString() {
        return "Login{student_email_address = " + student_email_address + ", password = " + password + ", staff_email_address = " + staff_email_address + ", staff_password = " + staff_password + "}";
    }
}
