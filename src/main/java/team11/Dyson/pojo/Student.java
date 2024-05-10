package team11.Dyson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ClassName: Student
 * Package: team11.Dyson.pojo
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 3:23
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentEmailAddress;
    private String stuName;
    private String password;
    private String gender;
    private Date birthday;
}
