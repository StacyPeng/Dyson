package team11.Dyson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domain.ResultVo;
import team11.Dyson.domain.StuClass;
import team11.Dyson.service.StuClassService;
import team11.Dyson.utils.ResultUtils;

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

//    @PutMapping
//    public ResultVo extension(@RequestParam("courseworkDeadline") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date courseworkDeadline,
//                              @RequestParam("classId") int classId, @RequestParam("studentEmailAddress") String studentEmailAddress) throws Exception {
//        boolean flag = stuClassService.extension(courseworkDeadline,classId,studentEmailAddress);
//        if (flag) {
//            return ResultUtils.success("extend success!");
//        }
//        return ResultUtils.error("extend fail!");
//    }

    @PostMapping
    public ResultVo extension(@RequestBody StuClass stuClass) throws Exception {
        boolean flag = stuClassService.extension(stuClass);
        if (flag) {
            return ResultUtils.success("extend success!");
        }
        return ResultUtils.error("extend fail!");
    }
}
