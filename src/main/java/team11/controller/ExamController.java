package team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.domian.Exam;
import team11.domian.Result;
import team11.service.ExamService;

import java.util.List;


/**
 * @author Chengyu Peng
 * @student ID:230045675
 */
@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/{examName}")
    public Result getByName(@PathVariable String examName) {
        Exam exam = examService.getByName(examName);
        Integer code = exam !=null?Code.GET_OK:Code.GET_ERR;
        String massage = exam != null?"":"fail to search, please input again";
        return new Result(code,exam,massage);
    }

    @GetMapping
    public Result getAll() {
        List<Exam> examList = examService.getAll();
        Integer code = examList !=null?Code.GET_OK:Code.GET_ERR;
        String massage = examList != null?"":"fail to search, please input again";
        return new Result(code,examList,massage);
    }
}
