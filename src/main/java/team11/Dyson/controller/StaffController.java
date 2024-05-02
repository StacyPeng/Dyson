package team11.Dyson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Login;
import team11.Dyson.domian.Result;
import team11.Dyson.domian.Staff;
import team11.Dyson.domian.Student;
import team11.Dyson.service.StaffService;
import team11.Dyson.service.impl.StudentServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/staffs")
@CrossOrigin(origins = "*")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/login")
    public Result login(@RequestBody Login login) {
        Staff staff = staffService.login(login.getStaff_email_address(),login.getStaff_password());
        Integer code = staff !=null?Code.GET_OK:Code.GET_ERR;
        String massage = staff != null?"":"fail to log in, please input again";
        return new Result(code,staff,massage);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Staff staff) {
        String msg = staffService.register(staff);
        boolean flag = ("SUCCESS").equals(msg);
        return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag);
    }

    @PutMapping("/modifypassword")
    public Result modifyPasswor(@RequestBody Map<String, String> requestBody) {
        String password = requestBody.get("password");
        String staff_email_address = requestBody.get("staff_email_address");
        boolean flag = staffService.modifyPassword(password,staff_email_address);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
}
