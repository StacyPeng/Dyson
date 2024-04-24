package team11.chengyu.service.impl;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.mapper.StudentMapper;
import team11.chengyu.domian.Student;
import team11.chengyu.service.StudentService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger log = (Logger) LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    @Override
    /*public Student login(String student_email_address, String password) {
        Student student = studentMapper.login(student_email_address, password);
        if (student != null) {
            if (password.equals(student.getPassword())) {
                return student;
            } else {
                return null;
            }
        }
        return null;
    }*/
    public Student login(String student_email_address, String password) {
        Student student = studentMapper.login(student_email_address, password);
        if (student != null) {
            if (password.equals(student.getPassword())) {
                log.info("Login successful for user: {}", student_email_address);
                return student;
            } else {
                log.warn("Incorrect password for user: {}", student_email_address);
                return null;
            }
        }
        log.warn("User not found: {}", student_email_address);
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
    public boolean modifyPassword(String password, String student_email_address) {
        boolean modifyPassword = studentMapper.modifyPassword(password, student_email_address);
        return modifyPassword;
    }

/*    @Override
    public boolean delete(String student_email_address) {
        studentMapper.delete(student_email_address);
        return true;
    }*/

    @Override
    public Student getByEmail(String student_email_address) {
        return studentMapper.getByEmail(student_email_address);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.getAll();
    }
}
