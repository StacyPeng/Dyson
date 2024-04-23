//Auther：Hengqian Mao
package team11.chengyu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team11.chengyu.domian.Course;

@Mapper
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
