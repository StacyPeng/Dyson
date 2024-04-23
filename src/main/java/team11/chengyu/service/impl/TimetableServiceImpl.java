package team11.chengyu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.Timetable;
import team11.chengyu.mapper.TimetableMapper;
import team11.chengyu.service.TimetableService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public class TimetableServiceImpl implements TimetableService {

    @Autowired
    private TimetableMapper timetableMapper;

    @Override
    public List<Timetable> getTimetables() {
        return timetableMapper.getAll();
    }
}
