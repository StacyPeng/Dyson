package team11.Dyson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team11.Dyson.domain.SignIn;

/*@author: Dechun Meng*/
@Mapper
public interface SignInMapper extends BaseMapper<SignIn> {
    @Insert("insert into sign_in (class_id, student_email_address, absence) values (#{classId}, #{studentEmailAddress}, #{absence})")
    public boolean signin(SignIn signIn);
}
