package team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.domian.Coursework;
import team11.domian.Result;
import team11.service.CourseworkService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/courseworks")
public class CourseworkController {
    @Autowired
    private CourseworkService courseworkService;

    @GetMapping("/{classId}")
    public Result getById(@PathVariable int classId) {
        Coursework coursework = courseworkService.getById(classId);
        Integer code = coursework !=null?Code.GET_OK:Code.GET_ERR;
        String massage = coursework != null?"":"fail to search, please input again";
        return new Result(code,coursework,massage);
    }

    @GetMapping
    public Result getAll() {
        List<Coursework> courseworkList = courseworkService.getAll();
        Integer code = courseworkList !=null?Code.GET_OK:Code.GET_ERR;
        String massage = courseworkList != null?"":"fail to search, please input again";
        return new Result(code,courseworkList,massage);
    }
}
