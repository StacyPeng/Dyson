package team11.Dyson.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
public class Timetable {
    private Integer class_id;
    private String class_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp class_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp end_time;
    private String room;
    private String staff_email_address;
    private Integer mod_Id;


    public Timetable() {
    }

    public Timetable(Integer class_id, String class_name, Timestamp class_time, Timestamp end_time, String room, String staff_email_address, Integer mod_Id) {
        this.class_id = class_id;
        this.class_name = class_name;
        this.class_time = class_time;
        this.end_time = end_time;
        this.room = room;
        this.staff_email_address = staff_email_address;
        this.mod_Id = mod_Id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Timestamp getClass_time() {
        return class_time;
    }

    public void setClass_time(Timestamp class_time) {
        this.class_time = class_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStaff_email_address() {
        return staff_email_address;
    }

    public void setStaff_email_address(String staff_email_address) {
        this.staff_email_address = staff_email_address;
    }

    public Integer getMod_Id() {
        return mod_Id;
    }

    public void setMod_Id(Integer mod_Id) {
        this.mod_Id = mod_Id;
    }

    public String toString() {
        return "Timetable{class_id = " + class_id + ", class_name = " + class_name + ", class_time = " + class_time + ", end_time = " + end_time + ", room = " + room + ", staff_email_address = " + staff_email_address + ", mod_Id = " + mod_Id + "}";
    }
}
