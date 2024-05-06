package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.service.impl.LoginService;

import java.util.Map;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/6 下午5:47
 * @student ID:230045675
 */
@RestController
@RequestMapping("/modifyPassword")
public class ModifyPasswordController {
    @Autowired
    private LoginService loginService;

    @PutMapping
    public String modifyPassword(@RequestBody Map<String, String> requestBody){
        String username = requestBody.get("username");
        return null;
    }
}
