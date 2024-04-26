package team11.domian;

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
@TableName("classes")
public class Classes {
    private Long classId;
    private String className;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date classTime;
    private String room;
    private String courseworkName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date courseworkDeadline;
}
