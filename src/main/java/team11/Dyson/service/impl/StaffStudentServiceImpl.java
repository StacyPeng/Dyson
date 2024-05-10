package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.StaffStudent;
import team11.Dyson.mapper.StaffStudentMapper;
import team11.Dyson.service.StaffStudentService;

import java.util.List;


/**
 * @author llh
 * @student ID:
 */
@Service
public class StaffStudentServiceImpl implements StaffStudentService {
    @Autowired
    public StaffStudentMapper staffStudentMapper;

    @Override
    public int insert(String staffEmailAddress, String studentEmailAddress) {
        return staffStudentMapper.insert(staffEmailAddress, studentEmailAddress);
    }

    @Override
    public List<StaffStudent> getStudentByStaff(String staffEmailAddress) {
        return staffStudentMapper.getByStaffEmail(staffEmailAddress);
    }

    @Override
    public List<StaffStudent> getStaffByStudent(String studentEmailAddress) {
        return staffStudentMapper.getByStudentEmail(studentEmailAddress);
    }

    @Override
    public int delete(String staffEmailAddress, String studentEmailAddress) {
        return staffStudentMapper.delete(staffEmailAddress, studentEmailAddress);
    }


}
