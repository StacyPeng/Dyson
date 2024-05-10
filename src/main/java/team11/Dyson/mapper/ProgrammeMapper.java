package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import team11.Dyson.domain.Programme;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 13:18
 * @student ID:230045675
 */
public interface ProgrammeMapper {
    @Select("select * from programme where proId = #{id}")
    public Programme getProgrammeById(int id);

    @Select("select * from programme where proName = #{programmeName}")
    public Programme getProgrammeByName(String programmeName);

    @Select("select * from programme ")
    public List<Programme> getAllProgramme();

    @Update("update programme set student_email_address=#{studentEmailAddress} where proId=#{proId}")
    public boolean modifyStudent(String studentEmailAddress,int proId);

    @Insert("insert into programme (proId, proName, description) values (#{proId},#{proName},#{description})")
    public boolean addProgramme(Programme programme);
}
