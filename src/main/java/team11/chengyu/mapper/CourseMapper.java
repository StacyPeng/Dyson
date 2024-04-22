package team11.chengyu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.chengyu.domian.Coursework;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface CourseMapper {
    @Select("select * from Classes where classId = #{classId}")
    public Coursework getById(int classId);

    @Select("select * from Classes")
    public List<Coursework> getAll();
}
