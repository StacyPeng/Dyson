package team11.Dyson.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domian.Coursework;
import team11.Dyson.mapper.CourseworkMapper;
import team11.Dyson.service.CourseworkService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class CourseworkServiceImpl implements CourseworkService {
    @Autowired
    private CourseworkMapper courseworkMapper;

    @Override
    public List<Coursework> getByName(String courseworkName) {
        return courseworkMapper.getByName(courseworkName);
    }

    @Override
    public List<Coursework> getAll() {
        return courseworkMapper.getAll();
    }
}
