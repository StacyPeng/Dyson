package team11.Dyson.service.impl;

import jakarta.transaction.Transactional;
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
public class UserService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StaffMapper staffMapper;


    public Optional<Object> userSort(String email) {
        // firstly try finding in students
        Optional<Student> student = Optional.ofNullable(studentMapper.getByEmail(email));
        if (student.isPresent()) {
            return Optional.of(student.get());
        }

        Optional<Staff> staff = Optional.ofNullable(staffMapper.getByEmail(email));
        if (staff.isPresent()) {
            return Optional.of(staff.get());
        }
        return Optional.empty();
    }

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

    /*public boolean modifyPassword(String email, String newPassword) {
        // Firstly try finding in students
        Optional<Student> student = Optional.ofNullable(studentMapper.getByEmail(email));
        if (student.isPresent()) {
            boolean studentFlag = studentMapper.modifyPassword(email, newPassword);
            if (studentFlag) {
                System.out.println("Password updated successfully for student: " + email);
                return true;
            } else {
                System.out.println("Failed to update password for student: " + email);
                return false;
            }
        }

        // If not found in students, then try finding in staffs
        Optional<Staff> staff = Optional.ofNullable(staffMapper.getByEmail(email));
        if (staff.isPresent()) {
            boolean staffFlag = staffMapper.modifyPassword(email, newPassword);
            if (staffFlag) {
                System.out.println("Password updated successfully for staff: " + email);
                return true;
            } else {
                System.out.println("Failed to update password for staff: " + email);
                return false;
            }
        }
        return false;
    }*/
}
