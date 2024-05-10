package team11.Dyson.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: llh

 */
@Data
@TableName("staff_student")
public class StaffStudent {
    private String staffEmailAddress;
    private String studentEmailAddress;


}
