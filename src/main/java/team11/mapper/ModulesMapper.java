package team11.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.domian.Modules;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface ModulesMapper {
    @Select("select * from modules where modName=#{modName}")
    public Modules getByName(String modName);

    @Select("select * from modules")
    public List<Modules> getAll();
}
