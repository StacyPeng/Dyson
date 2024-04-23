package team11.chengyu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import team11.chengyu.domian.Meeting;

/*@author: Dechun Meng*/
@Mapper
public interface MeetingMapper extends BaseMapper<Meeting> {

    @Insert("insert into meetings values (#{meeting_id},#{meeting_name},#{Time},#{student_email_address})")
    public boolean book(Meeting meeting);
}
