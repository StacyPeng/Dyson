package team11.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.domian.Timetable;
import team11.mapper.TimetableMapper;
import team11.service.TimetableService;

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
