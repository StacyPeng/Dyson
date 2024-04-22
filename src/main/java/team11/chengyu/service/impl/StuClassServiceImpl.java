package team11.chengyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.StuClass;
import team11.chengyu.mapper.StuClassMapper;
import team11.chengyu.service.StuClassService;

import java.util.Date;

/**
 * @ClassName: MeetingServiceImpl
 * @Description: Description of the class file
 * @author: Dechun Meng
 * @date: 2024/4/17 00:00
 */
@Service
public class StuClassServiceImpl extends ServiceImpl<StuClassMapper, StuClass> implements StuClassService {

    @Autowired
    private StuClassMapper stuClassMapper;

    @Override
    public boolean extension(Date courseworkDeadline, int classId, String studentEmailAddress) {
        boolean extension = stuClassMapper.extension(courseworkDeadline,classId,studentEmailAddress);
        return extension;
    }
}
