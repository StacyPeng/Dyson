package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Coursework;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface CourseworkMapper {
    @Select("select * from classes where class_id = #{classId}")
    public Coursework getById(int classId);

    @Select("select * from classes")
    public List<Coursework> getAll();
}
