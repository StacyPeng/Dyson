package team11.Dyson.service;

import com.baomidou.mybatisplus.extension.service.IService;
import team11.Dyson.domain.SignIn;

/**
 * @author: Dechun Meng
 * @InterfaceName: MeetingService
 * @Description: Description of the interface file
 */
public interface SignInService extends IService<SignIn> {
    public boolean signin(SignIn signIn);
}
