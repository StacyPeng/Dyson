package team11.chengyu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.chengyu.domian.Modules;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface ModulesMapper {
    @Select("select * from modules where mod_Id=#{modId}")
    public Modules getById(int modId);

    @Select("select * from modules")
    public List<Modules> getAll();
}
