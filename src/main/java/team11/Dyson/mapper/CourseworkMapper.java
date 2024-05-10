package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domain.Coursework;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface CourseworkMapper {
    @Select("select * from classes where coursework_name = #{courseworkName}")
    public List<Coursework> getByName(String courseworkName);

    @Select("select * from classes")
    public List<Coursework> getAll();
}
