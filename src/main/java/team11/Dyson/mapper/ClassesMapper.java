package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Classes;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/8 下午3:47
 * @student ID:230045675
 */
@Repository
@Mapper
public interface ClassesMapper {
    @Select("select * from classes where mod_Id=#{modId}")
    public List<Classes> getByModId(int modId);
}
