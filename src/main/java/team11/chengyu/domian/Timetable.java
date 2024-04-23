package team11.chengyu.domian;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Timetable {
    private Integer class_id;
    private String class_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime class_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime end_time;
    private String room;
    private String coursework_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime coursework_deadline;
    private String coursework_description;
    private String staff_email_address;
    private Integer mod_Id;


    public Timetable() {
    }

    public Timetable(Integer class_id, String class_name, LocalDateTime class_time, LocalDateTime end_time, String room, String coursework_name, LocalDateTime coursework_deadline, String coursework_description, String staff_email_address, Integer mod_Id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_time = class_time;
        this.end_time = end_time;
        this.room = room;
        this.coursework_name = coursework_name;
        this.coursework_deadline = coursework_deadline;
        this.coursework_description = coursework_description;
        this.staff_email_address = staff_email_address;
        this.mod_Id = mod_Id;
    }

    /**
     * 获取
     * @return class_id
     */
    public Integer getClass_id() {
        return class_id;
    }

    /**
     * 设置
     * @param class_id
     */
    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    /**
     * 获取
     * @return class_name
     */
    public String getClass_name() {
        return class_name;
    }

    /**
     * 设置
     * @param class_name
     */
    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    /**
     * 获取
     * @return class_time
     */
    public LocalDateTime getClass_time() {
        return class_time;
    }

    /**
     * 设置
     * @param class_time
     */
    public void setClass_time(LocalDateTime class_time) {
        this.class_time = class_time;
    }

    /**
     * 获取
     * @return end_time
     */
    public LocalDateTime getEnd_time() {
        return end_time;
    }

    /**
     * 设置
     * @param end_time
     */
    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    /**
     * 获取
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取
     * @return coursework_name
     */
    public String getCoursework_name() {
        return coursework_name;
    }

    /**
     * 设置
     * @param coursework_name
     */
    public void setCoursework_name(String coursework_name) {
        this.coursework_name = coursework_name;
    }

    /**
     * 获取
     * @return coursework_deadline
     */
    public LocalDateTime getCoursework_deadline() {
        return coursework_deadline;
    }

    /**
     * 设置
     * @param coursework_deadline
     */
    public void setCoursework_deadline(LocalDateTime coursework_deadline) {
        this.coursework_deadline = coursework_deadline;
    }

    /**
     * 获取
     * @return coursework_description
     */
    public String getCoursework_description() {
        return coursework_description;
    }

    /**
     * 设置
     * @param coursework_description
     */
    public void setCoursework_description(String coursework_description) {
        this.coursework_description = coursework_description;
    }

    /**
     * 获取
     * @return staff_email_address
     */
    public String getStaff_email_address() {
        return staff_email_address;
    }

    /**
     * 设置
     * @param staff_email_address
     */
    public void setStaff_email_address(String staff_email_address) {
        this.staff_email_address = staff_email_address;
    }

    /**
     * 获取
     * @return mod_Id
     */
    public Integer getMod_Id() {
        return mod_Id;
    }

    /**
     * 设置
     * @param mod_Id
     */
    public void setMod_Id(Integer mod_Id) {
        this.mod_Id = mod_Id;
    }

    public String toString() {
        return "ClassesPeng{class_id = " + class_id + ", class_name = " + class_name + ", class_time = " + class_time + ", end_time = " + end_time + ", room = " + room + ", coursework_name = " + coursework_name + ", coursework_deadline = " + coursework_deadline + ", coursework_description = " + coursework_description + ", staff_email_address = " + staff_email_address + ", mod_Id = " + mod_Id + "}";
    }
}
