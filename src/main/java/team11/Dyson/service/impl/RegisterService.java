package team11.Dyson.service.impl;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.mapper.StaffMapper;
import team11.Dyson.mapper.StudentMapper;
import team11.Dyson.repository.StudentRepository;

import java.util.Date;
import java.util.Optional;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/6 下午3:01
 * @student ID:230045675
 */
@Service
public class RegisterService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StaffMapper staffMapper;

    public Optional<Object> registerUser(String emailAddress,String name,String password,String gender,Date birthday) {
        // firstly try finding in students
        Optional<Student> student = studentMapper.register(new Student(emailAddress,name,password,gender,birthday));
        if (student.isPresent() && student.get().getPassword().equals(password)) {
            return Optional.of(student.get());
        }

        //if not found in students, then try finding in staffs
        Optional<Staff> staff = staffMapper.register(new Staff(emailAddress,name,password,gender,birthday));
        if (staff.isPresent() && staff.get().getPassword().equals(password)) {
            return Optional.of(staff.get());
        }

        return Optional.empty();
    }
}
