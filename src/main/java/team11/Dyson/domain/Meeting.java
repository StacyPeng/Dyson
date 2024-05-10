package team11.Dyson.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: Dechun Meng
 * @ClassName: Meeting
 * @Description: Description of the class file
 */
@Data
@TableName("meetings")
public class Meeting {
    @TableId(type = IdType.AUTO)
    private Long meeting_id;
    private String meeting_name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp Time;
    private String student_email_address;

//    public Meeting(Long meeting_id, String meeting_name, Timestamp Time, String student_email_address) {
//        this.meeting_id = meeting_id;
//        this.meeting_name = meeting_name;
//        this.Time = Time;
//        this.student_email_address = student_email_address;
//    }
}
