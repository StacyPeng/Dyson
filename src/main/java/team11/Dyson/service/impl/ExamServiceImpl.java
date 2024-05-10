package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.Exam;
import team11.Dyson.mapper.ExamMapper;
import team11.Dyson.service.ExamService;

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
