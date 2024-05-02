package team11.Dyson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;

@Mapper
@Repository
public interface StaffMapper extends BaseMapper<Staff> {

    @Select("select * from staff where staff_email_address=#{staff_email_address} and password=#{password}")
    public Staff login(String staff_email_address, String password);

    @Select("select * from staff where staff_email_address =#{staff_email_address}")
    public Staff getByEmail(String emailAddress);

    @Insert("insert into staff (staff_email_address, staName, password, gender, birthday)" +
            "values (#{staff_email_address},#{staName},#{password},#{gender},#{birthday})")
    //parameter name, not column name
    public int register(Staff staff);

    @Update("update staff set password=#{password} where staff_email_address=#{staff_email_address}")
    public boolean modifyPassword(String password,String staff_email_address);
}
