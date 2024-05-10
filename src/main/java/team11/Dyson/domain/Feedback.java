package team11.Dyson.domain;

public class Feedback {
    private String student_email_address;
    private String content;


    public Feedback() {
    }

    public Feedback(String student_email_address, String content) {
        this.student_email_address = student_email_address;
        this.content = content;
    }

    public String getStudent_email_address() {
        return student_email_address;
    }

    public void setStudent_email_address(String student_email_address) {
        this.student_email_address = student_email_address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "feedback{student_email_address = " + student_email_address + ", content = " + content + "}";
    }
}
