package team11.Dyson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.mapper.LoginMapper;
import team11.Dyson.pojo.Staff;
import team11.Dyson.pojo.Student;
import team11.Dyson.service.LoginService;

/**
 * ClassName: LoginStudentImpl
 * Package: team11.Dyson.service.impl
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 4:46
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    //学生登录的实现
    public Student login1(Student student){
        return loginMapper.login1(student);
    }

    //教师登录的实现
    public Staff login2(Staff staff){
        return loginMapper.login2(staff);
    }
}
