package team11.Dyson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import team11.Dyson.controller.UserController;
import team11.Dyson.domain.Student;
import team11.Dyson.service.StudentService;
import team11.Dyson.service.impl.UserService;

import java.util.Optional;

@SpringBootTest
class DysonApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Autowired
    private StudentService studentService;


    @Test
    public void testModifyPassword(){
        Optional<Object> object = userService.userSort("test@qq.com");
        System.out.println(object);
    }

    @Test
    public void testRegister(){
        Student student = new Student("suanle","suanle","suanle","male",null);
        String message = studentService.register(student);
        System.out.println(message);
    }
}
