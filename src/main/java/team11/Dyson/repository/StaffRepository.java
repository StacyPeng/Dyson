package team11.Dyson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team11.Dyson.domian.Staff;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Optional<Staff> findByStaffEmailAddress(String email);
}
