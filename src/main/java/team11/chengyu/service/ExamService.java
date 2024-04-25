package team11.chengyu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team11.chengyu.domian.Exam;
import team11.chengyu.domian.Student;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Transactional
@Service
public interface ExamService {

    public Exam getByName(String examName);

    public List<Exam> getAll();
}
