package team11.Dyson.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.pojo.Result;
import team11.Dyson.pojo.Staff;
import team11.Dyson.pojo.Student;
import team11.Dyson.service.LoginService;
import team11.Dyson.utils.JwtUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController
 * Package: team11.Dyson.controller
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 3:18
 * @Version 1.0
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    //学生登录
    @PostMapping("/login")
    public Result login1(@RequestBody Student student){
        log.info("student login:{}",student);

        //1 调用service完成业务
        Student loginStu =loginService.login1(student);

        //2 判断：登录用户是否存在
        if (loginStu != null) {
            //2.1 获取用户信息
            Map<String,Object> claims = new HashMap<>();
            claims.put("email",loginStu.getStudentEmailAddress());
            claims.put("password",loginStu.getPassword());

            //2.2 使用JWT工具类，生成令牌
            String token = JwtUtils.generateJwt(claims);
            System.out.println(token);

            //2.3 将token令牌返回给浏览器保存
            return Result.success(token);
        }
        //3 不存在：拒绝登录
        return Result.error("学生用户名或密码错误");
    }

    //教师登录
    @PostMapping("/sta/login")
    public Result login2(@RequestBody Staff staff){
        log.info("staff login:{}",staff);

        //1 调用service完成业务
        Staff loginStaff =loginService.login2(staff);

        //2 判断：登录用户是否存在
        if (loginStaff != null) {
            //2.1 获取用户信息
            Map<String,Object> map = new HashMap<>();
            map.put("email",loginStaff.getStaffEmailAddress());
            map.put("password",loginStaff.getPassword());

            //2.2 使用JWT工具类，生成令牌
            String token = JwtUtils.generateJwt(map);
            System.out.println(token);

            //2.3 将token令牌返回给浏览器保存
            return Result.success(token);
        }
        //3 不存在：拒绝登录
        return Result.error("教师用户名或密码错误");
    }
}
