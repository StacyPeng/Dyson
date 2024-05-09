    package team11.Dyson.mapper;

    import com.baomidou.mybatisplus.core.mapper.BaseMapper;
    import org.apache.ibatis.annotations.*;
    import org.apache.ibatis.annotations.Result;
    import org.springframework.stereotype.Repository;
    import team11.Dyson.domian.*;

    import java.util.List;


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

        @Insert("insert into student values (#{studentEmailAddress},#{stuName},#{password},#{gender},#{birthday})")
        //parameter name, not column name
        public int register(Student student);

        @Update("update student set password=#{password} where student_email_address=#{studentEmailAddress}")
        public boolean modifyPassword(String password,String studentEmailAddress);

        /*@Delete("delete from student where student_email_address=#{student_email_address}")
        public void delete(String emailAddress);*/

        @Results(id = "studentResultMap", value = {
                @Result(property = "student_email_address", column = "student_email_address"),
        })
        @Select("select student_email_address,* from student")
        public List<Student> getAll();

        @Select("SELECT * FROM classes classes LEFT JOIN stu_class stuclass ON " +
                "stuclass.class_id = classes.class_id WHERE stuclass.student_email_address = #{student_email_address}")
        public List<Classes> getClassesInfo(String emailAddress);

        @Select("SELECT * FROM modules where mod_Id= #{modId}")
        public Modules getModulesInfo(String modId);

        @Select("SELECT * FROM exames where modId= #{modId}")
        public Exam getExamInfo(String modId);

        @Select("SELECT a.*,b.modName FROM registeredmodules a left join modules b on b.mod_Id = a.modId  where a.student_email_address= #{student_email_address}")
        public List<Registeredmodules> getRegisteredmodulesInfo(String emailAddress);

    }
