package team11.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.domian.Student;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Transactional
@Service
public interface StudentService {

    public Object login(String student_email_address, String password);

    public String register(Student student);

    public boolean modifyPassword(String password,String student_email_address);

    //public boolean delete(Student student);

    public Student getByEmail(String student_email_address);

    public List<Student> getAll();
}
