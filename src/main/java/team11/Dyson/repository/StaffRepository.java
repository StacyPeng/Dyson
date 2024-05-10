package team11.Dyson.repository;
//Auther：Hengqian Mao
//c3008838
import org.springframework.data.jpa.repository.JpaRepository;
import team11.Dyson.domain.Staff;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByStaffEmailAddress(String email);
}
