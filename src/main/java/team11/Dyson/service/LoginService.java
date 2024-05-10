package team11.Dyson.service;

import team11.Dyson.pojo.Staff;
import team11.Dyson.pojo.Student;

/**
 * ClassName: LoginService
 * Package: team11.Dyson.service
 * Description:
 *
 * @Author Alina Hu
 * @Create 2024/5/7 3:35
 * @Version 1.0
 */
public interface LoginService{

    //学生登录的接口
    Student login1(Student student);

    //教师登录的接口
    Staff login2(Staff staff);
}


