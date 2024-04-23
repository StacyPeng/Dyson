package team11.chengyu.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import team11.chengyu.domian.Feedback;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface FeedbackMapper {

    @Insert("insert into feedback values (#{student_email_address},#{content})")
    public boolean upload(Feedback feedback);
}
