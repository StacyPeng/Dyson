package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.domian.Timetable;
import team11.Dyson.service.TimetableService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/timetables")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping
    public List<Timetable> getAll() {
        return timetableService.getTimetables();
    }
}
