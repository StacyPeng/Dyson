package team11.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import team11.mapper.StudentMapper;


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
        //@RequestParam接收前端数据，参数是前端的name
        if(studentMapper.getByEmail(email)!=null&& password.equals(studentMapper.getByEmail(email).getPassword())){
            //查到了用户而且密码正确
            session.setAttribute("LoginUser", email);//用户名传到session，用于安全控制
            return "dashboard";//跳转到dashboard页面
        }
        else {
            model.addAttribute("msg", "User name or password is incorrect");//显示错误信息
            return "index";//跳转到首页
        }
    }
}
