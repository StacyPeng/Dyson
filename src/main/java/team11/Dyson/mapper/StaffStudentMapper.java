package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.StaffStudent;

import java.util.List;

/**
 * @author llh
 * @student ID:
 */
@Mapper
@Repository
public interface StaffStudentMapper {

    //查询导师下的学生
    @Select("select * from staff_student where staff_email_address =#{staffEmailAddress}")
    public List<StaffStudent> getByStaffEmail(String staffEmailAddress);

    // 查询学生的导师
    @Select("select * from staff_student where student_email_address =#{student_email_address}")
    public List<StaffStudent>  getByStudentEmail(String emailAddress);

    @Insert("insert into staff_student (staff_email_address, student_email_address)" +
            "values (#{staffEmailAddress},#{studentEmailAddress})")
    public int insert(String staffEmailAddress, String studentEmailAddress);


    @Delete("delete from staff_student where staff_email_address =#{staffEmailAddress} and student_email_address =#{studentEmailAddress}")
    public int delete(String staffEmailAddress, String studentEmailAddress);


}
