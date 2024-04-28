//Auther：Hengqian Mao
package team11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team11.domian.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
