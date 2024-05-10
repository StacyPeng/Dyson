package team11.Dyson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import team11.Dyson.domain.Meeting;

/**
 * @author: Dechun Meng
 * @InterfaceName: MeetingService
 * @Description: Description of the interface file
 */
public interface MeetingService extends IService<Meeting> {

    public String bookMeeting(Meeting meeting);
}
