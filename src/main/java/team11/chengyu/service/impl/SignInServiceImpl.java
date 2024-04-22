package team11.chengyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team11.chengyu.domian.SignIn;
import team11.chengyu.mapper.SignInMapper;
import team11.chengyu.service.SignInService;

/**
 * @ClassName: MeetingServiceImpl
 * @Description: Description of the class file
 * @author: Dechun Meng
 * @date: 2024/4/17 00:00
 */
@Service
public class SignInServiceImpl extends ServiceImpl<SignInMapper, SignIn> implements SignInService {

    @Autowired
    private SignInMapper signInMapper;

    @Override
    public boolean signin(SignIn signIn) {
        boolean flag = signInMapper.signin(signIn);
        return flag;
    }
}
