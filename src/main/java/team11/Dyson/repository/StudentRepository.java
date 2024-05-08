package team11.Dyson.repository;
//Auther：Hengqian Mao
//c3008838
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team11.Dyson.domian.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentEmailAddress(String studentEmailAddress);
    boolean existsByStudentEmailAddress(String studentEmailAddress);
}

