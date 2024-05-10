package team11.Dyson.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.Dyson.domain.StuClass;
import team11.Dyson.mapper.StuClassMapper;
import team11.Dyson.service.StuClassService;

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
    public boolean extension(StuClass stuClass) {
        boolean extension = stuClassMapper.extensionInsert(stuClass);
        return extension;
    }
}
