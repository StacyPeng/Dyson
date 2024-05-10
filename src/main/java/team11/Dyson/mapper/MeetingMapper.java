package team11.Dyson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team11.Dyson.domain.Meeting;

/*@author: Dechun Meng*/
@Mapper
public interface MeetingMapper extends BaseMapper<Meeting> {

    @Insert("insert into meetings (meeting_name, time, student_email_address) values (#{meeting_name},#{Time},#{student_email_address})")
    public boolean book(Meeting meeting);
}
