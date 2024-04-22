package team11.chengyu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import team11.chengyu.domian.Meeting;

/**
 * @InterfaceName: MeetingService
 * @Description: Description of the interface file
 */
public interface MeetingService extends IService<Meeting> {

    public String bookMeeting(Meeting meeting);
}
