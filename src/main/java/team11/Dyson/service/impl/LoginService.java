package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.mapper.StaffMapper;
import team11.Dyson.mapper.StudentMapper;

import java.util.Optional;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/5 23:45
 * @student ID:230045675
 */
@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StaffMapper staffMapper;

    public Optional<Object> authenticateUser(String email, String password) {
        // firstly try finding in students
        Optional<Student> student = Optional.ofNullable(studentMapper.getByEmail(email));
        if (student.isPresent() && student.get().getPassword().equals(password)) {
            return Optional.of(student.get());
        }

        //if not found in students, then try finding in staffs
        Optional<Staff> staff = Optional.ofNullable(staffMapper.getByEmail(email));
        if (staff.isPresent() && staff.get().getPassword().equals(password)) {
            return Optional.of(staff.get());
        }

        return Optional.empty();
    }
}
