package team11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import team11.domian.ResultVo;
import team11.service.StuClassService;
import team11.utils.ResultUtils;

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
