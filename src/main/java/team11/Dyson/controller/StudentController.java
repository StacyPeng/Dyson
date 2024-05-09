package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import team11.Dyson.domian.*;
import team11.Dyson.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static team11.Dyson.service.impl.StudentServiceImpl.log;

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
    public Result login(@RequestBody StudentLogin login) {
        Student student = studentService.login(login.getStudentEmailAddress(),login.getStudentPassword());
        Integer code = student !=null?Code.GET_OK:Code.GET_ERR;
        String massage = student != null?"":"fail to log in, please input again";
        return new Result(code,student,massage);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Student student) {
        log.info("Received student registration: {}", student);
        String msg = studentService.register(student);
        boolean flag = ("SUCCESS").equals(msg);
        return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag);
    }

    @PutMapping("/modifypassword")
    public Result modifyPassword(@RequestBody Map<String, String> requestBody) {
        String password = requestBody.get("password");
        String student_email_address = requestBody.get("student_email_address");
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
        String massage = studentList != null?"successful to search":"fail to search, please input again";
        return new Result(code,studentList,massage);
    }

    //llh 查询课程考试成绩+学术历史
    @GetMapping("/getStudentInfo/{student_email_address}")
    public Result getStudentInfo(@PathVariable String student_email_address) {
        //获取课程作业
        List<Classes> classesInfo = studentService.getClassesInfo(student_email_address);

        List<Modules> modules = new ArrayList<>();
        for (Classes item : classesInfo) {
//            //科目信息
//            Modules modulesInfo = studentService.getModulesInfo(item.getModId());
//            modules.add(modulesInfo);

            //考试信息
            Exam examInfo = studentService.getExamInfo(item.getModId().toString());
            if (examInfo != null && examInfo.getExamId() != null && !StringUtils.isEmpty(examInfo.getExamId() + "")) {
                String achievement = examInfo.getAchievement();
                Double add = Double.parseDouble(achievement) + Double.parseDouble(item.getAchievement());
                //科目练习成绩+考试成绩
                item.setAchievement(add + "");
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        //学术历史
        List<Registeredmodules> registeredmodules = studentService.getRegisteredmodulesInfo(student_email_address);
        map.put("classesInfo", classesInfo);
        map.put("registeredmodules", registeredmodules);

//        List<Student> studentList = studentService.getAll();
        Integer code = map !=null?Code.GET_OK:Code.GET_ERR;
        String massage = map != null?"":"fail to search, please input again";
        return new Result(code,map,massage);
    }


}
