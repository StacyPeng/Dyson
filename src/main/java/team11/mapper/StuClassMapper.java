package team11.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import team11.domian.StuClass;

import java.util.Date;

/*@author: Dechun Meng*/
@Mapper
public interface StuClassMapper extends BaseMapper<StuClass> {

    @Update("update stu_class set coursework_deadline=#{courseworkDeadline} where class_id=#{classId} and student_email_address=#{studentEmailAddress}")
    public boolean extension(Date courseworkDeadline, int classId, String studentEmailAddress);
}
