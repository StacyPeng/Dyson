package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Login;
import team11.Dyson.domian.Result;
import team11.Dyson.domian.Student;
import team11.Dyson.service.impl.StudentServiceImpl;

import java.util.List;

/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        Student student = studentService.login(login.getStudent_email_address(),login.getPassword());
        Integer code = student !=null?Code.GET_OK:Code.GET_ERR;
        String massage = student != null?"":"fail to log in, please input again";
        return new Result(code,student,massage);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Student student) {
        String msg = studentService.register(student);
        boolean flag = ("SUCCESS").equals(msg);
        return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag);
    }

    @PutMapping("/modifypassword")
    public Result modifyPasswor(@RequestParam String password,String student_email_address) {
        boolean flag = studentService.modifyPassword(password,student_email_address);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    /*@DeleteMapping("/{student_email_address}")
    public Result delete(@PathVariable String student_email_address) {
        boolean flag = studentService.delete(student_email_address);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }*/

    /*@GetMapping("/{student_email_address}")
    public Result getByEmail(@PathVariable String student_email_address) {
        Student student  = studentService.getByEmail(student_email_address);
        Integer code = student !=null?Code.GET_OK:Code.GET_ERR;
        String massage = student != null?"":"fail to search, please input again";
        return new Result(code,student,massage);
    }*/

    @GetMapping
    public Result getAll() {
        List<Student> studentList = studentService.getAll();
        Integer code = studentList !=null?Code.GET_OK:Code.GET_ERR;
        String massage = studentList != null?"":"fail to search, please input again";
        return new Result(code,studentList,massage);
    }
}
