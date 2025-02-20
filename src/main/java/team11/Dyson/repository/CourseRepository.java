//Auther：Hengqian Mao
//c3008838
package team11.Dyson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team11.Dyson.domain.Course;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByTeacher_StaffEmailAddress(String email);
}

