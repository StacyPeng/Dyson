    package team11.Dyson.mapper;

    import com.baomidou.mybatisplus.core.mapper.BaseMapper;
    import org.apache.ibatis.annotations.*;
    import org.springframework.stereotype.Repository;
    import team11.Dyson.domian.Student;

    import java.util.List;
    import java.util.Optional;


    /**
     * @author Chengyu Peng
     * @student ID:230045675
     */
    @Mapper
    @Repository
    public interface StudentMapper extends BaseMapper<Student> {

        @Select("select * from student where student_email_address=#{studentEmailAddress} and password=#{password}")
        public Student login(String studentEmailAddress, String password);

        @Select("select * from student where student_email_address =#{studentEmailAddress}")
        public Student getByEmail(String emailAddress);

        @Insert("insert into student values (#{studentEmailAddress},#{stuName},#{password},#{gender},#{birthday},#{classId})")
        //parameter name, not column name
        public Student register(Student student);

        @Update("update student set password=#{password} where student_email_address=#{studentEmailAddress}")
        public boolean modifyPassword(String password,String studentEmailAddress);

        /*@Delete("delete from student where student_email_address=#{student_email_address}")
        public void delete(String emailAddress);*/

        @Results(id = "studentResultMap", value = {
                @Result(property = "student_email_address", column = "student_email_address"),
        })
        @Select("select * from student")
        public List<Student> getAll();
    }
