package team11.chengyu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team11.chengyu.domian.ResultVo;
import team11.chengyu.domian.SignIn;
import team11.chengyu.service.SignInService;
import team11.chengyu.utils.ResultUtils;


/**
 * @ClassName: StudentController
 * @Description: Description of the class file
 */
@RestController
@RequestMapping("/signin")
public class SigninController {

    @Autowired
    private SignInService signInService;

    @PostMapping("/notify_absence")
    public ResultVo notifyAbsence(@RequestBody SignIn signIn) throws Exception {
        signIn.setAbsence(1);
        boolean save = signInService.signin(signIn);
        if (save) {
            return ResultUtils.success("notify success!");
        }
        return ResultUtils.error("notify fail!");
    }
}
