package team11.Dyson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Result;
import team11.Dyson.domian.StaffStudent;
import team11.Dyson.service.StaffStudentService;

import java.util.List;

/**
 * @author llh
 * 导师分配学生
 */
@RestController
@RequestMapping("/staffstudent")
public class StaffStudentController {

    @Autowired
    private StaffStudentService staffStudentService;

    // 新增学生到导师名下
    @PostMapping("/insert")
    public Result login(@RequestBody StaffStudent staffStudent) {
        List<StaffStudent> staffStudents = staffStudentService.getStudentByStaff(staffStudent.getStaffEmailAddress());
        if (staffStudents.size() > 15) {
            return new Result(Code.GET_ERR, 0, "导师最多有15个学生");
        }else{
            int result = staffStudentService.insert(staffStudent.getStaffEmailAddress(),staffStudent.getStudentEmailAddress());
            Integer code = result > 0 ? Code.GET_OK : Code.GET_ERR;
            String massage = result > 0 ? "" : "fail to log in, please input again";
            return new Result(code, result, massage);
        }

    }

    //查询导师下的学生
    @GetMapping("/getStudentByStaff/{staffEmailAddress}")
    public Result getStudentByStaff(@PathVariable String staffEmailAddress) {
        List<StaffStudent> exam = staffStudentService.getStudentByStaff(staffEmailAddress);
        Integer code = exam !=null?Code.GET_OK:Code.GET_ERR;
        String massage = exam != null?"":"fail to search, please input again";
        return new Result(code,exam,massage);
    }

    //查询学生的导师
    @GetMapping("/getStaffByStudent/{studentEmailAddress}")
    public Result getStaffByStudent(@PathVariable String studentEmailAddress) {
        List<StaffStudent> exam = staffStudentService.getStaffByStudent(studentEmailAddress);
        Integer code = exam !=null?Code.GET_OK:Code.GET_ERR;
        String massage = exam != null?"":"fail to search, please input again";
        return new Result(code,exam,massage);
    }
    //删除学生
    @PostMapping("/delete")
    public Result delete(@RequestBody StaffStudent staffStudents) {
        int exam = staffStudentService.delete(staffStudents.getStaffEmailAddress(),staffStudents.getStudentEmailAddress());
        Integer code = exam > 0 ? Code.GET_OK : Code.GET_ERR;
        String massage = exam > 0 ? "" : "fail to search, please input again";
        return new Result(code,exam,massage);
    }

}
