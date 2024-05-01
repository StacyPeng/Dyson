package team11.Dyson.domian;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("stu_class")
public class StuClass {
    @TableId(type = IdType.AUTO)
    private Long stuClassId;
    private Long classId;
    private String studentEmailAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date courseworkDeadline;


    public StuClass(Long stuClassId, Long classId, String studentEmailAddress, Date courseworkDeadline) {
        this.stuClassId = stuClassId;
        this.classId = classId;
        this.studentEmailAddress = studentEmailAddress;
        this.courseworkDeadline = courseworkDeadline;
    }
}
