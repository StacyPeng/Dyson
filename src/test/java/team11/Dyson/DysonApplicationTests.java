package team11.Dyson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import team11.Dyson.controller.LoginController;
import team11.Dyson.controller.TimetableController;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.service.impl.LoginService;
import team11.Dyson.service.impl.StaffServiceImpl;
import team11.Dyson.service.impl.StudentServiceImpl;

import java.util.Optional;

@SpringBootTest
class DysonApplicationTests {

    @Autowired
    private TimetableController timetableController;

    @Autowired
    private StudentServiceImpl studentService;

    @Autowired
    private StaffServiceImpl staffService;

    @Autowired
    private LoginService loginService;

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

    @Test
    public void testLogin(){
        Optional<Object> object = loginService.authenticateUser("newstudent@qq.com", "newstudent");
        System.out.println(object);
    }
}
