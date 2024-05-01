package team11.Dyson.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team11.Dyson.mapper.StudentMapper;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentMapper studentMapper;

    public String login(@RequestParam("student_email_address") String email, @RequestParam("password") String password,
                        Model model, HttpSession session) {
        //@RequestParam receive data of front end，parameter is name of front end
        if(studentMapper.getByEmail(email)!=null&& password.equals(studentMapper.getByEmail(email).getPassword())){
            //find user and password is correct
            session.setAttribute("LoginUser", email);//username is sent to the session for security control
            return "dashboard";//redirect to landing page
        }
        else {
            model.addAttribute("msg", "User name or password is incorrect");//alert wrong message
            return "index";//redirect to index
        }
    }
}
