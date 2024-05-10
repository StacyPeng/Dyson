package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domain.*;
import team11.Dyson.service.StaffService;
import team11.Dyson.service.StudentService;
import team11.Dyson.service.impl.UserService;


import java.util.Optional;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StaffService staffService;


    @PostMapping("/login")
    public UserResult login(@RequestBody User request){
        Optional<Object> user = userService.authenticateUser(request.getEmailAddress(), request.getPassword());
        Integer code;
        String message;
        String identity;

        if (!user.isPresent()) {
            code = Code.LOG_ERR;
            message = "Unknown user, please try again";
            user = null;
            identity = null;
            return new UserResult(code,user,message,identity);
        }

        // Checks the user type and returns the appropriate view or URL
        if (user.get() instanceof Student) {
            Student student = (Student) user.get();
            code = Code.LOG_OK;
            message = "Student successfully logged in";
            identity = "student";
            return new UserResult(code,student,message,identity);
        }else if (user.get() instanceof Staff) {
            Staff staff = (Staff) user.get();
            code = Code.LOG_OK;
            message = "Staff successfully logged in";
            identity = "staff";
            return new UserResult(code,staff,message,identity);
        }
        return new UserResult(Code.SYSTEM_UNKNOW_ERR,null,"Unknown user",null);

    }

    /*@PutMapping("/modifypassword")
    public ResponseEntity<?> modifyPassword(@RequestBody User request) {
        boolean isPasswordChanged = userService.modifyPassword(request.getEmailAddress(), request.getPassword());
        if (isPasswordChanged) {
            return ResponseEntity.ok("Password successfully changed.");
        } else {
            return ResponseEntity.badRequest().body("Failed to change password. User may not exist.");
        }
    }*/

    /*@PutMapping("/modifypassword")
    public UserResult modifyPassword(@RequestBody User request) {
        Optional<Object> user = userService.userSort(request.getEmailAddress());
        int code;
        String message;
        String identity;

        if (!user.isPresent()) {
            code = Code.LOG_ERR;
            message = "Unknown user, please try again";
            user = null;
            identity = null;
            return new UserResult(code,user,message,identity);
        }else if (user.get() instanceof Student) {
            boolean flag = studentService.modifyPassword(request.getEmailAddress(), request.getPassword());
            return new UserResult(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
        }else if (user.get() instanceof Staff) {
            boolean flag = staffService.modifyPassword(request.getEmailAddress(), request.getPassword());
            return new UserResult(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
        }
        return new UserResult(Code.SYSTEM_UNKNOW_ERR,null,"Unknown user",null);
    }*/
}