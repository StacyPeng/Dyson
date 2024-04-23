package team11.chengyu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team11.chengyu.controller.StudentController;
import team11.chengyu.controller.TimetableController;
import team11.chengyu.service.impl.StudentServiceImpl;

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
