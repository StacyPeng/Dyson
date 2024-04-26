package team11.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.domian.Meeting;
import team11.domian.ResultVo;
import team11.service.MeetingService;
import team11.utils.ResultUtils;


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
        if (save=="SUCCESS") {
            return ResultUtils.success("book success!");
        }
        return ResultUtils.error("book fail!");
    }
}
