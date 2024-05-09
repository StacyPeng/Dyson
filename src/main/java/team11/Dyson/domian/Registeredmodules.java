package team11.Dyson.domian;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: llh
 * @ClassName: registeredmodules
 * @Description: Description of the class file
 */
@Data
@TableName("registeredmodules")
public class Registeredmodules {
    private String studentEmailAddress;
    private String modId;
    private String modName;


}
