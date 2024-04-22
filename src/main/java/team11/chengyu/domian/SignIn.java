package team11.chengyu.domian;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @ClassName: SignIn
 * @Description: Description of the class file
 */
@Data
@TableName("sign_in")
public class SignIn {
    private Long classId;
    private String studentEmailAddress;
    private int absence;

    public SignIn(Long classId, String studentEmailAddress, int absence) {
        this.classId = classId;
        this.studentEmailAddress = studentEmailAddress;
        this.absence = absence;
    }
}

