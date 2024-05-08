package team11.Dyson.domian;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: Dechun Meng
 * @ClassName: Classes
 * @Description: Description of the class file
 */
@Data
@TableName("classes")
public class Classes {
    private Long classId;
    private String className;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date classTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    private String room;
    private String courseworkName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date courseworkDeadline;
    private String courseDescription;
    private String achievement;
    private String staff_email_address;
    private Integer mod_Id;

}
