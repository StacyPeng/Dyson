package team11.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.domian.Exam;
import team11.mapper.ExamMapper;
import team11.service.ExamService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    public ExamMapper examMapper;

    @Override
    public Exam getByName(String examName) {
        return examMapper.getByName(examName);
    }

    @Override
    public List<Exam> getAll() {
        return examMapper.getAll();
    }
}
