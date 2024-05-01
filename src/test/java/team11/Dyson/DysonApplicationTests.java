package team11.Dyson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team11.Dyson.controller.TimetableController;
import team11.Dyson.service.impl.StudentServiceImpl;

@SpringBootTest
class DysonApplicationTests {

    @Autowired
    private TimetableController timetableController;

    @Autowired
    private StudentServiceImpl studentService;

    @Test
    public void testGetTimetable(){
        System.out.println(timetableController.getAll());
    }

    @Test
    public void testGetStudent(){
        System.out.println(studentService.getAll());
    }
}
