package team11.chengyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team11.chengyu.domian.Result;
import team11.chengyu.domian.ResultVo;
import team11.chengyu.domian.StuClass;
import team11.chengyu.service.StuClassService;
import team11.chengyu.utils.ResultUtils;

import java.util.Date;

/**
 * @author: Dechun Meng
 * @ClassName: StudentController
 * @Description: Description of the class file
 */
@RestController
@RequestMapping("/extension")
public class ExtensionController {

    @Autowired
    private StuClassService stuClassService;

    @PutMapping
    public ResultVo extension(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date courseworkDeadline,
                              @RequestParam int classId, @RequestParam String studentEmailAddress) throws Exception {
        boolean flag = stuClassService.extension(courseworkDeadline,classId,studentEmailAddress);
        if (flag) {
            return ResultUtils.success("extend success!");
        }
        return ResultUtils.error("extend fail!");
    }
}
