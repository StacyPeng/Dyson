package team11.chengyu.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.Coursework;
import team11.chengyu.mapper.CourseworkMapper;
import team11.chengyu.service.CourseworkService;

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
    public Coursework getById(int classId) {
        return courseworkMapper.getById(classId);
    }

    @Override
    public List<Coursework> getAll() {
        return courseworkMapper.getAll();
    }
}
