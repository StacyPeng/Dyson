package team11.Dyson.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Exam;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Mapper
@Repository
public interface ExamMapper {
    @Select("select * from Exames where examName =#{examName}")
    public Exam getByName(String examName);

    @Select("select * from Exames")
    public List<Exam> getAll();
}
