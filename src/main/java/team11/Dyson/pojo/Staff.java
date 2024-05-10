package team11.Dyson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Staff
 * Package: team11.Dyson.pojo
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 4:33
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    private String staffEmailAddress;
    private String staName;
    private String password;
    private String gender;
    private Date birthday;
}
