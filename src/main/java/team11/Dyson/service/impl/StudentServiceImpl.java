package team11.Dyson.service.impl;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.mapper.StudentMapper;
import team11.Dyson.domian.Student;
import team11.Dyson.service.StudentService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class StudentServiceImpl implements StudentService {
    public static final Logger log = (Logger) LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student login(String studentEmailAddress, String password) {
        Student student = studentMapper.login(studentEmailAddress, password);
        if (student != null) {
            if (password.equals(student.getPassword())) {
                log.info("Login successful for user: {}", studentEmailAddress);
                return student;
            } else {
                log.warn("Incorrect password for user: {}", studentEmailAddress);
                return null;
            }
        }
        log.warn("User not found: {}", studentEmailAddress);
        return null;
    }

    @Override
    public String register(Student student) {
        if ("".equals(student.getPassword())) {
            return "please input password";
        } else if ("".equals(student.getStudentEmailAddress())) {
            return "please input email address";
        } else {
            studentMapper.register(student);
            return "SUCCESS";
        }
    }


    @Override
    public boolean modifyPassword(String password, String studentEmailAddress) {
        boolean modifyPassword = studentMapper.modifyPassword(password, studentEmailAddress);
        return modifyPassword;
    }

/*    @Override
    public boolean delete(String student_email_address) {
        studentMapper.delete(student_email_address);
        return true;
    }*/

    @Override
    public Student getByEmail(String studentEmailAddress) {
        return studentMapper.getByEmail(studentEmailAddress);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }
}
