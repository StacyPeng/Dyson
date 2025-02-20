package team11.Dyson.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: Dechun Meng
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

