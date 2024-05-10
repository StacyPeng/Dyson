package team11.Dyson.service;

import org.springframework.stereotype.Service;
import team11.Dyson.domain.Timetable;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Service
public interface TimetableService {
    List<Timetable> getTimetables();
}
