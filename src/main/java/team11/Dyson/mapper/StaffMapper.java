package team11.Dyson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import team11.Dyson.domain.Staff;

@Mapper
@Repository
public interface StaffMapper extends BaseMapper<Staff> {

    @Select("select * from staff where staff_email_address=#{staffEmailAddress} and password=#{password}")
    public Staff login(String staffEmailAddress, String password);

    @Select("select * from staff where staff_email_address =#{staffEmailAddress}")
    public Staff getByEmail(String staffEmailAddress);

    @Insert("insert into staff (staff_email_address, staName, password, gender, birthday)" +
            "values (#{staffEmailAddress},#{staName},#{password},#{gender},#{birthday})")
    //parameter name, not column name
    public int register(Staff staff);

    @Update("update staff set password=#{password} where staff_email_address=#{staffEmailAddress}")
    public boolean modifyPassword(String password,String staffEmailAddress);
}
