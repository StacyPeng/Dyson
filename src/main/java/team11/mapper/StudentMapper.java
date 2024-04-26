package team11.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import team11.domian.Student;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from student where student_email_address=#{student_email_address} and password=#{password}")
    public Student login(String student_email_address, String password);

    @Select("select * from student where student_email_address =#{student_email_address}")
    public Student getByEmail(String emailAddress);

    @Insert("insert into student (student_email_address, stu_name, password, gender, birthday, class_id)" +
            "values (#{student_email_address},#{stuName},#{password},#{gender},#{birthday},#{class_id})")
    //parameter name, not column name
    public int register(Student student);

    @Update("update student set password=#{password} where student_email_address=#{student_email_address}")
    public boolean modifyPassword(String password,String student_email_address);

    /*@Delete("delete from student where student_email_address=#{student_email_address}")
    public void delete(String emailAddress);*/

    @Results(id = "studentResultMap", value = {
            @Result(property = "student_email_address", column = "student_email_address"),
    })
    @Select("select * from student")
    public List<Student> getAll();
}
