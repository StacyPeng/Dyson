package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.domian.*;
import team11.Dyson.service.impl.LoginService;

import java.util.Optional;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping
    public LoginResult login(@RequestBody Login request){
        Optional<Object> user = loginService.authenticateUser(request.getEmailAddress(), request.getPassword());
        Integer code;
        String message;
        String identity;

        if (!user.isPresent()) {
            code = Code.LOG_ERR;
            message = "Unknown user, please try again";
            user = null;
            identity = null;
            return new LoginResult(code,user,message,identity);
        }

        // Checks the user type and returns the appropriate view or URL
        if (user.get() instanceof Student) {
            Student student = (Student) user.get();
            code = Code.LOG_OK;
            message = "Student successfully logged in";
            identity = "student";
            return new LoginResult(code,student,message,identity);
        }else if (user.get() instanceof Staff) {
            Staff staff = (Staff) user.get();
            code = Code.LOG_OK;
            message = "Staff successfully logged in";
            identity = "staff";
            return new LoginResult(code,staff,message,identity);
        }
        return new LoginResult(Code.SYSTEM_UNKNOW_ERR,null,"Unknown user",null);

    }
}
