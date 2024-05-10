package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.Classes;
import team11.Dyson.mapper.ClassesMapper;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/8 下午3:58
 * @student ID:230045675
 */
@Service
public class ClassesService {

    @Autowired
    private ClassesMapper courseMapper;
    @Qualifier("classesMapper")
    @Autowired
    private ClassesMapper classesMapper;

    public List<Classes> getByModId(int modId) {
        return classesMapper.getByModId(modId);
    }
}
