package team11.Dyson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import team11.Dyson.domain.StuClass;

import java.util.Date;

/*@author: Dechun Meng*/
@Mapper
public interface StuClassMapper extends BaseMapper<StuClass> {

    @Update("update stu_class set coursework_deadline=#{courseworkDeadline} where class_id=#{classId} and student_email_address=#{studentEmailAddress}")
    public boolean extensionUpdate(Date courseworkDeadline, int classId, String studentEmailAddress);

    @Insert("INSERT INTO stu_class (coursework_deadline, class_id, student_email_address) VALUES (#{courseworkDeadline}, #{classId}, #{studentEmailAddress})")
    public boolean extensionInsert(StuClass stuClass);
}
