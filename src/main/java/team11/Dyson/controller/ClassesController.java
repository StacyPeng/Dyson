package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.Dyson.domian.Classes;
import team11.Dyson.domian.Result;
import team11.Dyson.service.impl.ClassesService;

import java.util.List;

/**
 * @Author: Chengyu Peng
 * @Date: 2024/5/8 下午4:03
 * @student ID:230045675
 */
@RestController
@RequestMapping("/classes")
public class ClassesController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/{modId}")
    public Result getByModId(@PathVariable("modId") int modId) {
        List<Classes> classes = classesService.getByModId(modId);
        int code = classes!=null?Code.GET_OK:Code.GET_ERR;
        String message = classes!=null?"success":"fail";
        return new Result(code,classes, message);
    }
}
