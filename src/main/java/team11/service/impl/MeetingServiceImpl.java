package team11.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.domian.Meeting;
import team11.mapper.MeetingMapper;
import team11.service.MeetingService;

/**
 * @ClassName: MeetingServiceImpl
 * @Description: Description of the class file
 * @author: Dechun Meng
 * @date: 2024/4/17 00:00
 */
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting> implements MeetingService {

    @Autowired
    private MeetingMapper meetingMapper;

    @Override
    public String bookMeeting(Meeting meeting) {
        boolean flag = meetingMapper.book(meeting);
        if (flag){
            return "SUCCESS";
        }else {
            return "Fail to book a meeting,please try again";
        }

    }
}
