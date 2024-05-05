package team11.Dyson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team11.Dyson.controller.TimetableController;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.service.impl.StaffServiceImpl;
import team11.Dyson.service.impl.StudentServiceImpl;

@SpringBootTest
class DysonApplicationTests {

    @Autowired
    private TimetableController timetableController;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private StaffServiceImpl staffService;

    @Test
    public void testGetTimetable(){
        System.out.println(timetableController.getAll());
    }

    @Test
    public void testGetStudent(){
        System.out.println(studentService.getAll());
    }

    @Test
    public void testRegisterStudent(){
        Student student = new Student("test","test","test","male",null,null);
        String register = studentService.register(student);
        System.out.println(register);
    }

    @Test
    public void testStaffLogin(){
        Staff staff = staffService.login("staff1@mail.com","staff1");
        System.out.println(staff);
    }
}
