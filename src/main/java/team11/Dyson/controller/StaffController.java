package team11.Dyson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domain.Result;
import team11.Dyson.domain.Staff;
import team11.Dyson.domain.StaffLogin;
import team11.Dyson.service.StaffService;

import java.util.Map;

@RestController
@RequestMapping("/staffs")
@CrossOrigin(origins = "*")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/login")
    public Result login(@RequestBody StaffLogin login) {
        Staff staff = staffService.login(login.getStaffEmailAddress(),login.getStaffPassword());
        Integer code = staff !=null?Code.GET_OK:Code.GET_ERR;
        String massage = staff != null?"Successful to log in":"Fail to log in, please input again";
        return new Result(code,staff,massage);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Staff staff) {
        String msg = staffService.register(staff);
        boolean flag = ("SUCCESS").equals(msg);
        return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERR,flag);
    }

    @PutMapping("/modifypassword")
    public Result modifyPassword(@RequestBody Map<String, String> requestBody) {
        String password = requestBody.get("password");
        String staff_email_address = requestBody.get("staff_email_address");
        boolean flag = staffService.modifyPassword(password,staff_email_address);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
}
