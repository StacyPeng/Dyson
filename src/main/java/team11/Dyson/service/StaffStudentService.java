package team11.Dyson.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.Dyson.domain.StaffStudent;

import java.util.List;


/**
 * @author llh
 * @student ID:
 */
@Transactional
@Service
public interface StaffStudentService {

    public int insert(String staffEmailAddress,String studentEmailAddress);
    public int delete(String staffEmailAddress,String studentEmailAddress);
    public List<StaffStudent> getStudentByStaff(String staffEmailAddress);
    public List<StaffStudent> getStaffByStudent(String studentEmailAddress);

}
