package team11.chengyu.domian;

public class Feedback {
    private String student_email_address;
    private String content;


    public Feedback() {
    }

    public Feedback(String student_email_address, String content) {
        this.student_email_address = student_email_address;
        this.content = content;
    }

    /**
     * 获取
     * @return student_email_address
     */
    public String getStudent_email_address() {
        return student_email_address;
    }

    /**
     * 设置
     * @param student_email_address
     */
    public void setStudent_email_address(String student_email_address) {
        this.student_email_address = student_email_address;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String toString() {
        return "feedback{student_email_address = " + student_email_address + ", content = " + content + "}";
    }
}
