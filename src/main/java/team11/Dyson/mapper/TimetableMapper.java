package team11.Dyson.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Timetable;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface TimetableMapper {
    @Results(id = "timetableResultMap", value = {
            @Result(property = "class_id", column = "class_id"),
            @Result(property = "class_name", column = "class_name"),
            @Result(property = "class_time", column = "class_time"),
            @Result(property = "end_time", column = "end_time"),
            @Result(property = "room", column = "room"),
            @Result(property = "staff_email_address", column = "staff_email_address"),
            @Result(property = "mod_Id", column = "mod_Id")
    })
    @Select("select class_id, class_name, class_time, end_time, room, staff_email_address, mod_Id from classes")
    public List<Timetable> getAll();
}
