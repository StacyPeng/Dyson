package team11.Dyson.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.Dyson.domian.Student;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Transactional
@Service
public interface StudentService {

    public Object login(String studentEmailAddress, String password);

    public String register(Student student);

    public boolean modifyPassword(String password,String studentEmailAddress);

    //public boolean delete(Student student);

    public Student getByEmail(String studentEmailAddress);

    public List<Student> getAll();
}
