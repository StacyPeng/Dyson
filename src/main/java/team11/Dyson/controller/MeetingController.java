package team11.Dyson.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team11.Dyson.domian.Meeting;
import team11.Dyson.domian.ResultVo;
import team11.Dyson.service.MeetingService;
import team11.Dyson.utils.ResultUtils;


/**
 * @author: Dechun Meng
 * @ClassName: StudentController
 * @Description: Description of the class file
 */
@RestController
@RequestMapping("/meetings")
public class MeetingController {
    @Autowired
    private MeetingService meetingService;

    @PostMapping("/book")
    public ResultVo bookMeeting(@RequestBody Meeting meeting) throws Exception {
        String save = meetingService.bookMeeting(meeting);
        if (save == "SUCCESS") {
            return ResultUtils.success("book success!");
        }
        return ResultUtils.error("book fail!");
    }


}
