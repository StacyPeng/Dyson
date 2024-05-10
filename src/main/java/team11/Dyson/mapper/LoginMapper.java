package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import team11.Dyson.pojo.Staff;
import team11.Dyson.pojo.Student;

/**
 * ClassName: LoginMapper
 * Package: team11.Dyson.mapper
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 4:51
 * @Version 1.0
 */
@Mapper
public interface LoginMapper {

    //学生登录
    @Select("select * from student where " +
            "student_email_address=#{studentEmailAddress} " +
            "and password=#{password}")
    Student login1(Student student);

    //教师登录
    @Select("select * from staff where " +
            "staff_email_address=#{staffEmailAddress} " +
            "and password=#{password}")
    Staff login2(Staff staff);

}
